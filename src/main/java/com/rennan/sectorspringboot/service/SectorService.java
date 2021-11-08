package com.rennan.sectorspringboot.service;

import com.rennan.sectorspringboot.domain.Sector;
import com.rennan.sectorspringboot.domain.service.SectorSd;
import com.rennan.sectorspringboot.util.exception.DomainException;
import org.hibernate.sql.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SectorService {

    @Autowired
    SectorSd sectorServiceDomain;

    @Transactional
    public void create(Sector sector) throws DomainException {
        sectorServiceDomain.create(sector);
    }

    public List<Sector> getAll(){
        return sectorServiceDomain.getAll();
    }
}
