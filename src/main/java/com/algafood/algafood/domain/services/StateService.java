package com.algafood.algafood.domain.services;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public Optional<State> findById(String id) {
        return Optional.ofNullable(stateRepository.findById(id));
    }
}
