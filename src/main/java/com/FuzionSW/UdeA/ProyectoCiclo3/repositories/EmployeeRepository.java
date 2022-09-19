package com.FuzionSW.UdeA.ProyectoCiclo3.repositories;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Long countById(long id);

    @Query(value="SELECT * FROM employee where enterprise_id= ?1", nativeQuery=true)
    public List<Employee> findByEnterprise(Long id);
}
