package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.State;

import java.util.List;

public interface StateRepository {

  public List<State> findAll();
}