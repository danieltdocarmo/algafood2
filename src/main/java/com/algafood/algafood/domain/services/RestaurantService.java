package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.Restaurant;
import com.algafood.algafood.domain.repositories.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private KitchenService kitchenService;

  
  public List<Restaurant> findAll() {
    return restaurantRepository.list();
  }

  public Optional<Restaurant> findById(long id) {
    return Optional.ofNullable(restaurantRepository.findById(id));
  }
  
  @Transactional
  public Restaurant save(Restaurant restaurant) {
    final var kitchenFound = kitchenService.findById(restaurant.getKitchen().getId().toString());

    if(kitchenFound.isEmpty()) {
      throw new EmptyResultDataAccessException(1);
    }
    
    return restaurantRepository.saveOrUpdate(restaurant);
  }

  @Transactional
  public void delete(long id) {
    final var restaurantToRemove = findById(id)
      .orElseThrow(() -> new EmptyResultDataAccessException(1));
    restaurantRepository.remove(restaurantToRemove);
  }

  @Transactional
  public Restaurant update(long id, Restaurant newRestaurant) {
      final var foundRestaurant = findById(id);

      return foundRestaurant.map(oldRestaurant -> {
          BeanUtils.copyProperties(newRestaurant, oldRestaurant, "id");
          return save(oldRestaurant);
      }).orElseThrow(() -> new EmptyResultDataAccessException(1));
  }

}