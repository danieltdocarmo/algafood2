package com.algafood.algafood.infra.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algafood.algafood.domain.repositories.PaymentFormRepository;
import org.springframework.stereotype.Repository;

import com.algafood.algafood.domain.entities.PaymentForm;

@Repository
public class PaymentFormRepositoryImpl implements PaymentFormRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<PaymentForm> list() {
        return manager.createQuery("from PaymentForm", PaymentForm.class).getResultList();
    }
}