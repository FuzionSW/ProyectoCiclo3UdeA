package com.FuzionSW.UdeA.ProyectoCiclo3.Repository;

import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotacion que le dice a Spring que esta clase es un repositorio
public interface EnterpriseRepository extends CrudRepository<Enterprise,Long> {

}

