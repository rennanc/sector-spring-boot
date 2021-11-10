package com.rennan.sectorspringboot.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateAgreeToTerms;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Sector> sectorList;

    public Profile() {
        dateAgreeToTerms = new Date();
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

    public Date getDateAgreeToTerms() {
        return dateAgreeToTerms;
    }

    public void setDateAgreeToTerms(Date dateAgreeToTerms) {
        this.dateAgreeToTerms = dateAgreeToTerms;
    }

    public Set<Sector> getSectorList() {
        return sectorList;
    }

    public void setSectorList(Set<Sector> sectorList) {
        this.sectorList = sectorList;
    }
}
