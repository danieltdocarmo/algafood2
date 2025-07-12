package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.Kitchen;
import com.algafood.algafood.domain.exceptions.EntityInUseException;
import com.algafood.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public Optional<Kitchen> findById(String id) {
        return Optional.ofNullable(kitchenRepository.findById(id));
    }

    public List<Kitchen> list() {
        return kitchenRepository.list();
    }

    @Transactional
    public Kitchen save(Kitchen kitchen) {
        return kitchenRepository.saveOrUpdate(kitchen);
    }

    @Transactional
    public Kitchen update(Kitchen kitchen, String id) {
        final var foundKitchen = findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(kitchen, foundKitchen, "id");
        
        return kitchenRepository.saveOrUpdate(foundKitchen);
    }

    public void delete(String id) {
        try {
                final var foundKitchen = findById(id);
                foundKitchen.orElseThrow(() -> new EmptyResultDataAccessException(1));
                kitchenRepository.delete(foundKitchen.get());
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format("Kitchen with id %s cannot be deleted because it is in use", id), e);
        }
        
    }
}
