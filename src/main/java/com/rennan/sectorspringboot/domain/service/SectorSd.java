package com.rennan.sectorspringboot.domain.service;

import com.rennan.sectorspringboot.data.IPostgresSectorData;
import com.rennan.sectorspringboot.domain.Sector;
import com.rennan.sectorspringboot.util.exception.DomainException;
import com.rennan.sectorspringboot.domain.enums.ErrorSystemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SectorSd {

    @Autowired
    private IPostgresSectorData postgresSectorData;

    public void create(Sector sector) throws DomainException {

        if(isThereEqual(sector.getName())){
            throw new DomainException(ErrorSystemType.ERROR_1);
        }

        postgresSectorData.save(sector);
    }

    private boolean isThereEqual(String profileName){
        return postgresSectorData.findByName(profileName) != null;
    }

    public List<Sector> getAll() {
        return (List<Sector>) postgresSectorData.findAll();
    }
}
