package com.rennan.sectorspringboot.data;

import com.rennan.sectorspringboot.domain.Sector;
import org.springframework.data.repository.CrudRepository;

public interface IPostgresSectorData extends CrudRepository<Sector, Long> {
    Sector findByName(String profileName);
}
