package com.algafood.algafood.controllers;

import java.util.List;

import com.algafood.algafood.domain.entities.State;
import com.algafood.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController{

   @Autowired
   private StateRepository stateRepository;

   @GetMapping
   @ResponseBody
   public List<State> list() {
     return stateRepository.findAll();
   }
}