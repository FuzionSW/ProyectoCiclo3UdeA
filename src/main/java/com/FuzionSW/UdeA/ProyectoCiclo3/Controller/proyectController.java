package com.FuzionSW.UdeA.ProyectoCiclo3.Controller;

import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.RoleName;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class proyectController {
    @GetMapping({"/pruebaEmpresa"})
    public String pruebaEmpresa(){
        Enterprise enterprise = new Enterprise();
        enterprise.setName("Empresa Prueba 1");
        enterprise.setAddress("Mi casa");
        enterprise.setPhone("Mi numero de telefono");
        enterprise.setDocument("NIT Generado");
        return enterprise.getId() + " " + enterprise.getName() + " " + enterprise.getAddress() + " " + enterprise.getDocument() + " " + enterprise.getPhone();
    }

    @GetMapping({"/pruebaEmpleado"})
    public String pruebaEmpleado(){
        Employee employee = new Employee();
        employee.setName("Pepito Perez");
        employee.setEmail("Pepito@elmejorprogramador.com");

        Enterprise enterprise = new Enterprise();
        enterprise.setName("Empresa Prueba 1");
        employee.setEnterprise(enterprise);

        RoleName role = RoleName.OPERATOR;
        employee.setRole(role);
        return employee.getId() + " " + employee.getName() + " " + employee.getEmail() + " " + employee.getEnterprise().getName() + " " + employee.getRole().getRoleName();
    }

    @GetMapping({"/pruebaMovimiento"})
    public String pruebaMovimiento(){
        Transaction transaction = new Transaction();
        transaction.setAmount(-10000.5);
        transaction.setConcept("Deuda");

        Employee user = new Employee();
        user.setName("Pepito Perez");
        transaction.setEmployee(user);

        Enterprise enterprise = new Enterprise();
        enterprise.setName("Empresa Prueba 1");
        transaction.setEnterprise(enterprise);

        return transaction.getId() + " " + transaction.getConcept() + " " + transaction.getAmount() + " " + transaction.getEmployee().getName() + " " + transaction.getEnterprise().getName();
    }


}
