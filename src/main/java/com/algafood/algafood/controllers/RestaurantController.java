package com.algafood.algafood.controllers;

import com.algafood.algafood.domain.entities.Restaurant;
import com.algafood.algafood.domain.services.RestaurantService;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

   @Autowired
   private RestaurantService restaurantService;

   @GetMapping
   public List<Restaurant> getAllRestaurants()   {
       return restaurantService.findAll();
   }

  @GetMapping("/{id}")
  public ResponseEntity<Restaurant> getRestaurantById(@PathVariable long id) {
      final var restaurantFound = restaurantService.findById(id);

    return restaurantFound.map(restaurant ->
            ResponseEntity.ok(restaurant))
            .orElseGet(() ->
                    ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
    return ResponseEntity.ok(restaurantService.save(restaurant));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
      try {
      final var updatedRestaurant = restaurantService.update(id, restaurant);
          return ResponseEntity.ok(updatedRestaurant);
      } catch (EntityNotFoundException e) {
          return ResponseEntity.notFound().build();
      } catch (IllegalArgumentException e) {
          return ResponseEntity.badRequest().build();
      }
      }

    @PatchMapping
    public ResponseEntity<Restaurant> updatePartial(@PathVariable Long id, @RequestBody Map<String, Object> restaurant) {
        
    }
}