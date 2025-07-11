package com.algafood.algafood.controllers;

import com.algafood.algafood.domain.entities.Restaurant;
import com.algafood.algafood.domain.services.RestaurantService;
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
}