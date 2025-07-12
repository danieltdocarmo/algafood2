package com.algafood.algafood.controllers;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.exceptions.EntityInUseException;
import com.algafood.algafood.domain.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
   public ResponseEntity<State> getStatesById(@PathVariable Long id) {
      final var state = stateService.findById(id);
      return state.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @PostMapping
   public ResponseEntity create(@RequestBody State state) {
       return ResponseEntity.ok(stateService.create(state));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity delete(@PathVariable Long id) {
      try {
         stateService.delete(id);
         return ResponseEntity.noContent().build();
      } catch (EntityInUseException e) {
          return ResponseEntity.status(HttpStatus.CONFLICT).build();
      } catch (EntityNotFoundException e) {
          return ResponseEntity.notFound().build();
      }
   }

   @PutMapping
   public ResponseEntity<State> update(@PathVariable Long id, @RequestBody State state) {
      try {
         final var updatedState = stateService.update(id, state);
          return ResponseEntity.ok(updatedState);
      } catch (EntityNotFoundException e) {
          return ResponseEntity.notFound().build();
      }
   }
   
   
}