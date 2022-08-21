package com.FuzionSW.UdeA.ProyectoCiclo3;

import com.FuzionSW.UdeA.ProyectoCiclo3.Models.Employee;
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
	@GetMapping({"/pruebaEmpresa"})
	public String pruebaEmpresa() {
		Enterprise empresa = new Enterprise();
		empresa.setName("Artelak SAS");
		empresa.setDocument("901362654");
		empresa.setPhone("323526576");
		empresa.setAddress("Calle la Jeta");

		return empresa.getName() + " " + empresa.getDocument() + " " + empresa.getPhone() + " " + empresa.getAddress();
	}

	@GetMapping({"/pruebaEmleado"})
	public String pruebaEmpleado() {
		Employee empleado = new Employee();
		empleado.setName("Mauricio");
		empleado.setEmail("artelak@gmail.com");
		empleado.setEnterprise("Artealk SAS");
		empleado.setRole("Administrador");

		return empleado.getName() + " " + empleado.getEmail() + " " + empleado.getEnterprise() + " " + empleado.getRole();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCiclo3Application.class, args);
	}

}
