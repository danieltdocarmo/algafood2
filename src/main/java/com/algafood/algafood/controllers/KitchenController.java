package com.algafood.algafood.controllers;

import com.algafood.algafood.domain.entities.Kitchen;
import com.algafood.algafood.domain.repositories.KitchenRepository;
import com.algafood.algafood.domain.services.KitchenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.algafood.algafood.domain.exceptions.EntityInUseException;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

    @GetMapping
    public List<Kitchen> getAllKitchens() {
        return kitchenService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> getKitchenById(@PathVariable String id) {
        final var kitchen = kitchenService.findById(id);

        return kitchen.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
        return ResponseEntity.ok(kitchenService.save(kitchen));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Kitchen> update(@PathVariable String id, @RequestBody Kitchen kitchen) {
        try {
        final var updatedKitchen = kitchenService.update(kitchen, id);
            return ResponseEntity.ok(updatedKitchen);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }   

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            kitchenService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
