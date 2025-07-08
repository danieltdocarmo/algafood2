package com.algafood.algafood.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.algafood.algafood.domain.entities.Kitchen;

@Repository
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager persistence;

    public List<Kitchen> list() {
        return persistence.createQuery("from Kitchen", Kitchen.class).getResultList();
    }
}