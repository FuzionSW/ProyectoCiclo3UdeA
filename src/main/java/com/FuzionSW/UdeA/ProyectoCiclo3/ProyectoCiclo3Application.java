package com.FuzionSW.UdeA.ProyectoCiclo3;

import com.FuzionSW.UdeA.ProyectoCiclo3.Models.Enterprise;
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

	@GetMapping({"/testEmpresa"})
	public String testEmpresa() {
		Enterprise enterprise = new Enterprise();			// Se crea la empresa
		//Empresa enterprise = new Empresa("Artelak", "Calle la Gta", "3213213211", "800212132-3");
		enterprise.setName("Artelak SAS");					// Se modifica el nombre
		enterprise.setAddress("Calle la Jeta");				// Se modifica la dirección
		enterprise.setPhone("3213213211");					// Se modifica el teléfono
		enterprise.setDocument("800212132-3");				// Se modifica el NIT
		return enterprise.getName() + " " + enterprise.getAddress() + " " + enterprise.getPhone() + " " + enterprise.getDocument();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCiclo3Application.class, args);
	}

}
