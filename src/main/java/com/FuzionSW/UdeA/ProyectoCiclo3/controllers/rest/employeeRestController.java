package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.rest;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.employee.EmployeeNotFoundException;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeeRestController {
    private final EmployeeService employeeService;

    public employeeRestController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }

    @GetMapping({"/users"})
    public List<Employee> getEmployeeList() {
        return this.employeeService.getEmployeeList();
    }

    @GetMapping(value = "/users/{id}")
    public Employee getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        return this.employeeService.getEmployee(id);
    }

    @PostMapping(value = "/users")
    public Employee postEmployee(@RequestBody Employee employee){
        return this.employeeService.createEmployee(employee);
    }

    @PatchMapping(path = "/users/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            Employee employeeUpdated = employeeService.getEmployee(id);
            employeeUpdated.setName(employee.getName());
            employeeUpdated.setEmail(employee.getEmail());
            employeeUpdated.setEnterprise(employee.getEnterprise());
            employeeUpdated.setRole(employee.getRole());
            employeeService.saveEmployee(employeeUpdated);
            return ResponseEntity.ok(employeeUpdated);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        boolean isRemoved = this.employeeService.isEmployeeDeleted(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
