package com.FuzionSW.UdeA.ProyectoCiclo3.repositories;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    public Long countById(long id);

    //Metodo para filtrar movimientos por empleado
    @Query(value ="select * from transaction where user_id= ?1", nativeQuery = true)
    public abstract ArrayList<Transaction> findByEmployee(Long id);

    //Metodo para filtrar movimientos por empresa
    @Query(value="SELECT * FROM transaction where enterprise_id= ?1", nativeQuery=true)
    public List<Transaction> findByEnterprise(Long id);

    //Metodo para sumar movimientos por empresa
    @Query(value="SELECT SUM(amount) FROM transaction where enterprise_id= ?1", nativeQuery=true)
    public abstract float amountByEnterprise(Long id);
}

