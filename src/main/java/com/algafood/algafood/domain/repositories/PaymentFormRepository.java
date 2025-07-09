package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.PaymentForm;

import java.util.List;

public interface PaymentFormRepository {

    public List<PaymentForm> list();
}