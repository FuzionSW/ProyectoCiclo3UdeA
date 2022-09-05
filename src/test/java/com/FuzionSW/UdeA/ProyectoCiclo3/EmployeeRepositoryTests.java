package com.FuzionSW.UdeA.ProyectoCiclo3;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.RoleName;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EmployeeRepository;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EnterpriseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void  testAddNewEmployee(){
        Employee employee = new Employee();
        employee.setName("Juan");
        employee.setEmail("juan@gmail.com");

        Enterprise enterprise = new Enterprise();
        enterprise.setName("La 14");
        enterprise.setDocument("81238456-8");
        enterprise.setPhone("3103103102");
        enterprise.setAddress("Calle 14");
        Enterprise savedEnterprise = enterpriseRepository.save(enterprise);

        employee.setEnterprise(enterprise);
        employee.setRole(RoleName.ADMIN);

        Employee savedEmployee = employeeRepository.save(employee);

        Employee existEmployee = entityManager.find(Employee.class, savedEmployee.getId());
        assertThat(existEmployee.getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    public void testListAllEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();
        assertThat(employees).hasSizeGreaterThan(0);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testUpdateEmployee() {
        long employeeId = 2;
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.get();
        employee.setName("Pedro");
        employee.setRole(RoleName.OPERATOR);
        employeeRepository.save(employee);

        Employee updatedEmployee = employeeRepository.findById(employeeId).get();
        assertThat(updatedEmployee.getName()).isEqualTo("Pedro");
    }

    @Test
    public void testGetEmployee(){
        long employeeId = 1;
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        assertThat(optionalEmployee).isPresent();
        System.out.println(optionalEmployee.get());
    }

    @Test
    public void testDeleteEmployee(){
        long employeeId = 1;
        employeeRepository.deleteById(employeeId);

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        assertThat(optionalEmployee).isNotPresent();
    }
}
