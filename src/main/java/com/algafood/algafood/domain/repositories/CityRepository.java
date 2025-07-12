package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.City;

import java.util.List;

public interface CityRepository {

    public List<City> list();

    public City findById(Long id);

    public City saveOrUpdate(City city);

    public void delete(Long id);
}