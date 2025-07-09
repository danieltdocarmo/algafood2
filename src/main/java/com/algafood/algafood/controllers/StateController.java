package com.algafood.algafood.controllers;

import java.util.List;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.repositories.StateRepository;
import com.algafood.algafood.domain.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state")
public class StateController{

   @Autowired
   private StateService stateService;

   @GetMapping
   public List<State> getAllStates() {
     return stateService.getAllStates();
   }

   @GetMapping("/{id}")
   public ResponseEntity<State> getStatesById(@PathVariable String id) {
      final var state = stateService.findById(id);

      return state.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }
}