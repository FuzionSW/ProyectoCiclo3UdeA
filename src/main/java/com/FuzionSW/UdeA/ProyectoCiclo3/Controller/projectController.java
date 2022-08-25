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
    public String pruebaEmpresa(){
        Enterprise enterprise = new Enterprise();
        enterprise.setName("Artelak");
        enterprise.setAddress("Calle 13");
        enterprise.setPhone("3213213211");
        enterprise.setDocument("8521234-6");
        return enterprise.getId() + " " + enterprise.getName() + " " + enterprise.getAddress() + " " + enterprise.getDocument() + " " + enterprise.getPhone();
    }

    @GetMapping({"/pruebaEmpleado"})
    public String pruebaEmpleado(){
        Employee employee = new Employee();
        employee.setName("Pepito Perez");
        employee.setEmail("pepito@perez.com");

        Enterprise enterprise = new Enterprise();
        enterprise.setName("Artelak");
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
        enterprise.setName("Artelak");
        transaction.setEnterprise(enterprise);

        return transaction.getId() + " " + transaction.getConcept() + " " + transaction.getAmount() + " " + transaction.getEmployee().getName() + " " + transaction.getEnterprise().getName();
    }
}
