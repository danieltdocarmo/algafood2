package com.algafood.algafood.repositories;

import com.algafood.algafood.domain.entities.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository{

    @PersistenceContext
    private EntityManager persistence;

    @Override
    @Transactional
    public Restaurant saveOrUpdate(Restaurant restaurant) {
        return persistence.merge(restaurant);
    }

    @Override
    @Transactional
    public void remove(Restaurant restaurant) {
        final var foundRestaurant = findById(restaurant.getId());
        persistence.remove(foundRestaurant);
    }

    @Override
    public List<Restaurant> list() {
        return persistence.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    public Restaurant findById(String id) {
        return persistence.find(Restaurant.class, id);
    }
}
