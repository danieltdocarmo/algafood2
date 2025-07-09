package com.algafood.algafood.infra.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algafood.algafood.domain.repositories.CityRepository;
import org.springframework.stereotype.Repository;

import com.algafood.algafood.domain.entities.City;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<City> list() {
        return manager.createQuery("from City", City.class).getResultList();
    }
}