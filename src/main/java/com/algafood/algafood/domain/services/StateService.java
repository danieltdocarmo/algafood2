package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.exceptions.EntityInUseException;
import com.algafood.algafood.domain.repositories.StateRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
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

    public State create(State state) {
        return stateRepository.saveOrUpdate(state);    
    }

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

    public State update(Long id, State state) {
        final var foundState = findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entidade state com id : %d não foi encontrada".formatted(id)));

        BeanUtils.copyProperties(state, foundState, "id");

        return stateRepository.saveOrUpdate(foundState);
    }
}
