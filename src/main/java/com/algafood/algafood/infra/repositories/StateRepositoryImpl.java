package com.algafood.algafood.infra.repositories;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.repositories.StateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class StateRepositoryImpl implements StateRepository {

  @PersistenceContext
  private EntityManager manager;
  
  public List<State> list() {
    return manager.createQuery("from State", State.class).getResultList();  
  }

  public State findById(Long id) {
        return manager.find(State.class, id);
  }

    @Transactional
    @Override
    public State saveOrUpdate(State state) {
       return manager.merge(state);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       final var state = findById(id);
      
       if(isNull(state)){
         throw new EntityNotFoundException("State not found");
       }
      
       manager.remove(state);
    }
}