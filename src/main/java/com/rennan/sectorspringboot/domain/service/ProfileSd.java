package com.rennan.sectorspringboot.domain.service;

import com.rennan.sectorspringboot.data.IPostgresProfileData;
import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.util.exception.DomainException;
import com.rennan.sectorspringboot.domain.enums.ErrorSystemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfileSd {

    @Autowired
    private IPostgresProfileData postgresProfileData;

    public Profile save(Profile profile) throws DomainException {

        if(profile.getId() == 0L && isThereEqual(profile.getName())){
            throw new DomainException(ErrorSystemType.ERROR_1);
        }

        return postgresProfileData.save(profile);
    }

    private boolean isThereEqual(String profileName){
        return postgresProfileData.findByName(profileName) != null;
    }

    public List<Profile> getAll() {
        return (List<Profile>) postgresProfileData.findAll();
    }

    public Optional<Profile> get(long id) {
        return postgresProfileData.findById(id);
    }
}
