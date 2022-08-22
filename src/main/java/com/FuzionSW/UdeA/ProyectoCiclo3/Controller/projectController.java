package com.FuzionSW.UdeA.ProyectoCiclo3.Controller;

import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.RoleName;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class projectController {
    @GetMapping({"/pruebaEmpresa"})
    public String pruebaEmpresa() {
        Enterprise enterprise = new Enterprise();			// Se crea la empresa
        //Empresa enterprise = new Empresa("Artelak", "Calle la Gta", "3213213211", "800212132-3");
        enterprise.setName("Artelak SAS");					// Se modifica el nombre
        enterprise.setAddress("Calle 13");				// Se modifica la dirección
        enterprise.setPhone("3213213211");					// Se modifica el teléfono
        enterprise.setDocument("800212132-3");				// Se modifica el NIT
        return enterprise.getId() + " " + enterprise.getName() + " " + enterprise.getAddress() + " " + enterprise.getPhone() + " " + enterprise.getDocument();
    }

    @GetMapping({"/pruebaEmpleado"})
    public String pruebaEmpleado() {
        Employee empleado = new Employee();
        empleado.setName("Mauricio");
        empleado.setEmail("artelak@gmail.com");

        Enterprise empresa = new Enterprise();
        empresa.setName("Artelak SAS");
        empleado.setEnterprise(empresa);
        RoleName role = RoleName.ADMIN;
        empleado.setRole(role);

        return empleado.getId() + " " + empleado.getName() + " " + empleado.getEmail() + " " + empleado.getEnterprise().getName() + " " + empleado.getRole().getRoleName();
    }

    @GetMapping({"/pruebaMovimiento"})
    public String pruebaMovimiento() {
        Transaction movimientoDinero = new Transaction();
        movimientoDinero.setAmount(-20500.3);
        movimientoDinero.setConcept("Ventas");

        Employee user = new Employee();
        user.setName("Mauricio");
        movimientoDinero.setUser(user);
        return movimientoDinero.getId() + " " + movimientoDinero.getAmount() + " " + movimientoDinero.getConcept() + " " + movimientoDinero.getUser().getName();
    }
}
