package com.rennan.sectorspringboot.data;

import com.rennan.sectorspringboot.domain.Profile;
import com.rennan.sectorspringboot.domain.Sector;
import org.springframework.data.repository.CrudRepository;

public interface IPostgresProfileData extends CrudRepository<Profile, Long> {
    Sector findByName(String profileName);
}
