package com.algafood.algafood.controllers;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.services.StateService;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

   @DeleteMapping
   public ResponseEntity delete(@PathVariable Long id) {
      try {
         stateService.delete(id);
         return ResponseEntity.noContent().build();
      } catch ( e) {
          return ResponseEntity.status(HttpStatus.CONFLICT).build();
      } catch (EntityNotFoundException e) {
          return ResponseEntity.notFound().build();
      }
   }

   @PutMapping
   public ResponseEntity<State> update(@PathVariable Long id, @RequestBody State state) {
      try {
          return ResponseEntity.ok(stateService.update(id, state));
      } catch (EntityNotFoundException e) {
          return ResponseEntity.notFound().build();
      }
   }
   
   
}