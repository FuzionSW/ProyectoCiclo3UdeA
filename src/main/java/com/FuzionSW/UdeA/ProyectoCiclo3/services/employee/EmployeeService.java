package com.FuzionSW.UdeA.ProyectoCiclo3.services.employee;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }

        throw new EmployeeNotFoundException("No se pudo encontrar ningún usuario con el Id: " + id);
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public boolean isEmployeeDeleted(Long id) throws EmployeeNotFoundException {
        boolean isRemoved = false;

        Long count = employeeRepository.countById(id);
        if (count == null || count ==0){
            throw new EmployeeNotFoundException("No se pudo encontrar ningún usuario con el Id: " + id);
        }
        else {
            employeeRepository.deleteById(id);
            isRemoved=true;
        }
        return isRemoved;
    }

    public void deleteEmployee(long id) throws EmployeeNotFoundException {
        Long count = employeeRepository.countById(id);
        if (count == null || count ==0){
            throw new EmployeeNotFoundException("No se pudo encontrar ningún usuario con el Id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
