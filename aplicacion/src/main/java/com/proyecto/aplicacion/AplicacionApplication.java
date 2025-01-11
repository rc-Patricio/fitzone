package com.proyecto.aplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.proyecto")
@EnableJpaRepositories("com.proyecto.repositorios") 
@EntityScan("com.proyecto.modelos")
public class AplicacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionApplication.class, args);
	}

}
