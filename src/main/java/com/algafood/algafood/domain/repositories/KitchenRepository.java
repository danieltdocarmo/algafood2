package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.Kitchen;

import java.util.List;

public interface KitchenRepository {

    public List<Kitchen> list();

    public Kitchen findById(String id);
}
