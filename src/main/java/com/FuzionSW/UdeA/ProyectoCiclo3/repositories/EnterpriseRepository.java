package com.FuzionSW.UdeA.ProyectoCiclo3.repositories;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotacion que le dice a Spring que esta clase es un repositorio
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {

    public Long countById(long id);
}

