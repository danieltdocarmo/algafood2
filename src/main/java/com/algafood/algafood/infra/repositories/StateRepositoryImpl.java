package com.algafood.algafood.infra.repositories;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.repositories.StateRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

  @PersistenceContext
  private EntityManager manager;
  
  public List<State> list() {
    return manager.createQuery("from State", State.class).getResultList();  
  }

  public State findById(Long id) {
    return manager.find(State.class, Long.valueOf(id));
  }

    @Override
    public State saveOrUpdate(State state) {
       return manager.merge(state);
    }

    @Override
    public void delete(Long id) {
       final var state = findById(id);
      
       if(state == null){
         throw new EntityNotFoundException("State not found");
       }
      
       manager.remove(state);
    }
}