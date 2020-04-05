package com.dawes;

import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GonzaloRodriguez10IdentificadorRestYSeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(GonzaloRodriguez10IdentificadorRestYSeguridadApplication.class, args);

		Persistence.generateSchema("jpa", null);
	}

}
