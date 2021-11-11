package com.rennan.sectorspringboot.service;

import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.domain.service.ProfileSd;
import com.rennan.sectorspringboot.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProfileService {

    @Autowired
    ProfileSd profileServiceDomain;

    @Transactional
    public Profile save(Profile profile) throws DomainException {
        return profileServiceDomain.save(profile);
    }

    public List<Profile> getAll() {
        return profileServiceDomain.getAll();
    }

    public Optional<Profile> get(long id) {
        return profileServiceDomain.get(id);
    }
}
