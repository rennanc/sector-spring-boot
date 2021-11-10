package com.rennan.sectorspringboot.view.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProfileDto {

    private long id;
    private String name;
    private boolean isAgreeTerms;
    private List<Integer> sectorsIndexSelected;

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

    public List<Integer> getSectorsIndexSelected() {
        return sectorsIndexSelected;
    }

    public void setSectorsIndexSelected(List<Integer> sectorsIndexSelected) {
        this.sectorsIndexSelected = sectorsIndexSelected;
    }
}