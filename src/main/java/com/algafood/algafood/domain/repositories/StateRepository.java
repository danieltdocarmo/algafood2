package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.State;

import java.util.List;

public interface StateRepository {

  public List<State> list();

  public State findById(Long id);

  public State saveOrUpdate(State city);

  public void delete(Long id);
}