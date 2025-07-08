package com.algafood.algafood.controllers;

import com.algafood.algafood.domain.entities.Kitchen;
import com.algafood.algafood.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller()
public class KitchenController {

    @Autowired
    private KitchenRepository kitchenRepository;

    @GetMapping("/kitchen")
    @ResponseBody
    public List<Kitchen> getAllKitchens() {
        return kitchenRepository.list();
    }
}
