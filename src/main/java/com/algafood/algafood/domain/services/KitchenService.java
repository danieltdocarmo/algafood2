package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.Kitchen;
import com.algafood.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
