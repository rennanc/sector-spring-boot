package com.rennan.sectorspringboot.data;

import com.rennan.sectorspringboot.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface IPostgresProfileData extends CrudRepository<Profile, Long> {
    Profile findByName(String profileName);
}
