package com.rennan.sectorspringboot.domain.service;

import com.rennan.sectorspringboot.data.IPostgresProfileData;
import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.domain.Sector;
import com.rennan.sectorspringboot.util.exception.DomainException;
import com.rennan.sectorspringboot.util.exception.ErrorSystemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ProfileSd {

    @Autowired
    private IPostgresProfileData postgresProfileData;

    public void create(Profile profile) throws DomainException {

        if(isThereEqual(profile.getName())){
            throw new DomainException(ErrorSystemType.ERROR_1);
        }

        postgresProfileData.save(profile);
    }

    private boolean isThereEqual(String profileName){
        return postgresProfileData.findByName(profileName) != null;
    }

    public List<Profile> getAll() {
        return (List<Profile>) postgresProfileData.findAll();
    }
}
