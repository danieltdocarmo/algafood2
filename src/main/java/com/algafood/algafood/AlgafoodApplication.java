package com.algafood.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgafoodApplication {

	public static void main(String[] args) {
		final var app = new SpringApplication(AlgafoodApplication.class);
		//app web
		//app.setWebApplicationType(WebApplicationType.SERVLET);
		//app non web		
		app.setWebApplicationType(WebApplicationType.NONE);

		app.run(args);
	}

}
