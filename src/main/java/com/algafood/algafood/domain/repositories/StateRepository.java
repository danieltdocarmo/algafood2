package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.State;

import java.util.List;
import java.util.Optional;

public interface StateRepository {

   List<State> list();

   State findById(Long id);

   State saveOrUpdate(State city);

   void delete(Long id);
}