package com.FuzionSW.UdeA.ProyectoCiclo3.services.employee;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired                                         //Conectamos esta clase con el repositorio de Empresa
    private EmployeeRepository employeeRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

    //Metodo que retornará la lista de empresas usando metodos heredados del jpaRepository
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

    public boolean delete(Long id) throws EmployeeNotFoundException {
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
