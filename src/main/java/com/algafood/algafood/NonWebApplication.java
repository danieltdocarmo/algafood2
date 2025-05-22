package com.algafood.algafood;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.algafood.algafood.repositories.KitchenDao;

public class NonWebApplication {

    public static void main(String[] args) {
        final var app = new SpringApplication(AlgafoodApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

    }
}