package com.FuzionSW.UdeA.ProyectoCiclo3.repositories;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    public Long countById(long id);

    //Metodo para filtrar movimientos por empleado
    @Query(value ="select * from transaction where user_id= ?1", nativeQuery = true)
    public abstract ArrayList<Transaction> findByEmployee(Long id);

    //Metodo para filtrar movimientos por empresa
    @Query(value="select * from transaction where user_id in (select id from empleado where enterprise_id= ?1)", nativeQuery = true)
    public abstract ArrayList<Transaction> findByEnterprise(Long id);
}

