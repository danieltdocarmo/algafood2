package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.exceptions.EntityInUseException;
import com.algafood.algafood.domain.repositories.StateRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates() {
        return stateRepository.list();
    }

    @Transactional
    public State create(State state) {
        return stateRepository.saveOrUpdate(state);    
    }

    @Transactional
    public void delete(Long id) {
        try {
            stateRepository.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format("State with id %s cannot be deleted because it is in use", id), e);
        }
    }
    
    public Optional<State> findById(Long id) {
        return Optional.ofNullable(stateRepository.findById(id));
    }
}
