package com.FuzionSW.UdeA.ProyectoCiclo3.Controller;

import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.RoleName;
import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class projectController {

    private final AtomicLong idEnterprise = new AtomicLong(0);
    private final ArrayList<Enterprise> empresas = new ArrayList<>();
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    @GetMapping({"/pruebaEmpresa"})
    public Enterprise getEnterprise(@RequestParam(value = "name", defaultValue = "Artelak") String name,
                                    @RequestParam(value = "document", defaultValue = "8521234-6") String document,
                                    @RequestParam(value = "phone", defaultValue = "3213213211") String phone,
                                    @RequestParam(value = "address", defaultValue = "Calle 13") String address
    ){
        Enterprise empresa = new Enterprise(idEnterprise.incrementAndGet(),
                                            String.format(name),
                                            String.format(document),
                                            String.format(phone),
                                            String.format(address)
                                            );
        empresas.add(empresa);
        return empresa;
    }

    @GetMapping({"/pruebaEmpresas"})
    public List<Enterprise> getAllEnterprise(@RequestParam(value = "name", defaultValue = "Mi empresa") String name,
                                             @RequestParam(value = "document", defaultValue = "NIT empresa") String document,
                                             @RequestParam(value = "phone", defaultValue = "Telefono empresa") String phone,
                                             @RequestParam(value = "address", defaultValue = "Dirección empresa") String address
                                             ){
        Enterprise empresa = new Enterprise(idEnterprise.incrementAndGet(),
                                            String.format(name),
                                            String.format(document),
                                            String.format(phone),
                                            String.format(address)
                                            );
        empresas.add(empresa);
        return empresas;
    }

    private final AtomicLong idEmployee = new AtomicLong(0);
    @GetMapping({"/pruebaEmpleado"})
    public List<Employee> getEmpleado(@RequestParam(value = "nameEmployee", defaultValue = "Pepito Perez") String nameEmployee,
                                @RequestParam(value = "emailEmployee", defaultValue = "Pepito Perez") String emailEmployee,
                                @RequestParam(value = "nameEnterprise", defaultValue = "Artelak") String nameEnterprise,
                                @RequestParam(value = "roleName", defaultValue = "Operador") String roleName
                                ){
        Employee employee = new Employee();
        employee.setId(idEmployee.incrementAndGet());
        employee.setName(nameEmployee);
        employee.setEmail(emailEmployee);

        Enterprise enterprise = new Enterprise();
        enterprise.setName(nameEnterprise);
        employee.setEnterprise(enterprise);

        RoleName role;
        if (roleName.equals("Administrador"))
            role = RoleName.ADMIN;
        else
            role = RoleName.OPERATOR;
        employee.setRole(role);

        employees.add(employee);

        return employees;
    }

    private final AtomicLong idTransaction = new AtomicLong(0);
    @GetMapping({"/pruebaMovimiento"})
    public List<Transaction> getTransaction(@RequestParam(value = "amount", defaultValue = "0") long amount,
                                            @RequestParam(value = "concept", defaultValue = "Concepto") String concept,
                                            @RequestParam(value = "nameEmployee", defaultValue = "Pepito Perez") String nameEmployee,
                                            @RequestParam(value = "nameEnterprise", defaultValue = "Empresa") String nameEnterprise
                                        ){
        Transaction transaction = new Transaction();
        transaction.setId(idTransaction.incrementAndGet());
        transaction.setAmount(amount);
        transaction.setConcept(concept);

        Employee user = new Employee();
        user.setName(nameEmployee);
        transaction.setEmployee(user);

        Enterprise enterprise = new Enterprise();
        enterprise.setName(nameEnterprise);
        transaction.setEnterprise(enterprise);

        transactions.add(transaction);

        return transactions;
    }
}
