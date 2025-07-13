package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.Restaurant;
import com.algafood.algafood.domain.repositories.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


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

  public Restaurant update(long id, Restaurant newRestaurant) {
      final var foundRestaurant = findById(id);

      final var foundKitchen = kitchenService.findById(newRestaurant.getKitchen().getId().toString());
    
      if(foundKitchen.isEmpty()) {
          throw new IllegalArgumentException("Kitchen not found");
      }
    
      return foundRestaurant.map(oldRestaurant -> {
          BeanUtils.copyProperties(newRestaurant, oldRestaurant, "id");
          return save(oldRestaurant);
      }).orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
  }

  public Restaurant updatePartial(long id, Map<String, Object> newFields) {
      final var foundRestaurant = findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
      final var objectMapper = new ObjectMapper();
      final var newRestaurant = objectMapper.convertValue(newFields, Restaurant.class); 
    
    newFields.forEach((key, value) -> {
        final var field = ReflectionUtils.findField(Restaurant.class, key);
        field.setAccessible(true);
        final var fieldValue = ReflectionUtils.getField(field, newRestaurant);
        ReflectionUtils.setField(field, foundRestaurant, fieldValue);
      }); 

     return save(foundRestaurant);
  }


}