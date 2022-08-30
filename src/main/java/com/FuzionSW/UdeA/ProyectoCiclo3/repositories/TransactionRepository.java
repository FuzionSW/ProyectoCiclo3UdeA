package com.FuzionSW.UdeA.ProyectoCiclo3.repositories;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    public Long countById(long id);
}
