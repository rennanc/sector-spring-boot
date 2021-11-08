package com.rennan.sectorspringboot.data.postgres;

import com.rennan.sectorspringboot.data.IPostgresSectorData;
import com.rennan.sectorspringboot.domain.Sector;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public abstract class PostgresSectorData implements IPostgresSectorData {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Sector findByName(String aliasName){

        StringBuilder jpql = new StringBuilder(" SELECT alias from Sector sector ")
                .append(" WHERE UPPER(sector.name) = UPPER(:name) ");


        TypedQuery<Sector> query = manager.createQuery(jpql.toString(), Sector.class);
        query.setParameter("name", aliasName);

        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
