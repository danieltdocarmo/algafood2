package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.Kitchen;

import java.util.List;

public interface KitchenRepository {

     List<Kitchen> list();

     Kitchen findById(String id);

     Kitchen saveOrUpdate(Kitchen kitchen);

    void delete(Kitchen kitchen);
}
