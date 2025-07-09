package com.algafood.algafood.infra.repositories;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.repositories.StateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

  @PersistenceContext
  private EntityManager manager;
  
  public List<State> findAll() {
    return manager.createQuery("from State", State.class).getResultList();  
  }

  public State findById(String id) {
    return manager.find(State.class, Long.valueOf(id));
  }
}