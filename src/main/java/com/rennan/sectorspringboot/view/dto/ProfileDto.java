package com.rennan.sectorspringboot.view.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.domain.Sector;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProfileDto {

    private long id;
    private String name;
    @JsonProperty
    private boolean isAgreeTerms;
    private List<Long> sectorsIndexSelected;

    public ProfileDto() {

    }

    public ProfileDto(Optional<Profile> profile) {
        profile.ifPresent(value -> {
            this.id = value.getId();
            this.name = value.getName();
            this.isAgreeTerms = value.getDateAgreeToTerms() != null;
            List<Long> list = new ArrayList<>();
            for (Sector sector : profile.get().getSectorList()) {
                Long xId = sector.getId();
                list.add(xId);
            }
            this.sectorsIndexSelected = list;
        });
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAgreeTerms() {
        return isAgreeTerms;
    }

    public void setAgreeTerms(boolean agreeTerms) {
        isAgreeTerms = agreeTerms;
    }

    public List<Long> getSectorsIndexSelected() {
        return sectorsIndexSelected;
    }

    public void setSectorsIndexSelected(List<Long> sectorsIndexSelected) {
        this.sectorsIndexSelected = sectorsIndexSelected;
    }

    public Profile getEntity() {
        Profile profile = new Profile();
        profile.setId(this.id);
        profile.setName(this.name);
        profile.setDateAgreeToTerms(new Date());

        Set<Sector> sectors = new HashSet<>();
        sectorsIndexSelected.stream().forEach(x -> {
            sectors.add(new Sector(x));
        });
        profile.setSectorList(sectors);
        return profile;
    }
}
