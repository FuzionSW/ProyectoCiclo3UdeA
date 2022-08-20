package com.FuzionSW.UdeA.ProyectoCiclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(
		exclude = {SecurityAutoConfiguration.class}
)
public class ProyectoCiclo3Application {

	@GetMapping({"/hello"})
	public String hello() {
		return "Hola Ciclo 3... Saldremos vivos de esto!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCiclo3Application.class, args);
	}

}
