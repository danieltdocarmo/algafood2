package com.algafood.algafood.infra.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.algafood.algafood.domain.repositories.CityRepository;
import org.springframework.stereotype.Repository;

import com.algafood.algafood.domain.entities.City;
import org.springframework.util.ObjectUtils;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<City> list() {
        return manager.createQuery("from City", City.class).getResultList();
    }

    @Override
    public City findById(Long id) {
        return manager.find(City.class, id);
    }

    @Override
    public City saveOrUpdate(City city) {
    return manager.merge(city);}

    @Override
    public void delete(Long id) {
        final var city = findById(id);

        if(city == null) {
            throw new EntityNotFoundException("City not found");
        }
        
        manager.remove(city);
    }
}