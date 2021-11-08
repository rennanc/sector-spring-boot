package com.rennan.sectorspringboot.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateAgreeToTerms;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Sector> sectorList;

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

    public Date getDateAgreeToTerms() {
        return dateAgreeToTerms;
    }

    public void setDateAgreeToTerms(Date dateAgreeToTerms) {
        this.dateAgreeToTerms = dateAgreeToTerms;
    }

    public List<Sector> getSectorList() {
        return sectorList;
    }

    public void setSectorList(List<Sector> sectorList) {
        this.sectorList = sectorList;
    }
}
