package com.algafood.algafood.infra.repositories;

import com.algafood.algafood.domain.entities.Kitchen;
import com.algafood.algafood.domain.repositories.KitchenRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager persistence;

    @Override
    public List<Kitchen> list() {
        return persistence.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Override
    public Kitchen findById(String id) {
        return persistence.find(Kitchen.class, Long.valueOf(id));
    }
}