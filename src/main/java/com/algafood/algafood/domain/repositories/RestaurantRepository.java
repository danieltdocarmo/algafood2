package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.Restaurant;

import java.util.List;

public interface RestaurantRepository {

     Restaurant saveOrUpdate(Restaurant restaurant);

    void remove(Restaurant restaurant);

    List<Restaurant> list();

    Restaurant findById(long id);
    
}
