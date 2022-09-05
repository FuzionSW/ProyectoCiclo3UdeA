package com.FuzionSW.UdeA.ProyectoCiclo3.services.transaction;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionList(){
        return transactionRepository.findAll();
    }

    public Transaction getTransaction(long id) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()){
            return optionalTransaction.get();
        }

        throw new TransactionNotFoundException("No se pudo encontrar ninguna transacción con el Id: " + id);
    }

    public Transaction createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public boolean isTransactionDeleted(Long id) throws TransactionNotFoundException {
        boolean isRemoved = false;

        Long count = transactionRepository.countById(id);
        if (count == null || count ==0){
            throw new TransactionNotFoundException("No se pudo encontrar ninguna transacción con el Id: " + id);
        }
        else {
            transactionRepository.deleteById(id);
            isRemoved=true;
        }
        return isRemoved;
    }

    public void deleteTransaction(long id) throws TransactionNotFoundException {
        Long count = transactionRepository.countById(id);
        if (count == null || count ==0){
            throw new TransactionNotFoundException("No se pudo encontrar ninguna transacción con el Id: " + id);
        }
        transactionRepository.deleteById(id);
    }

    public ArrayList<Transaction> findByEmployee(Long id) { //Obterner teniendo en cuenta el id del empleado
        return transactionRepository.findByEmployee(id);
    }

    public ArrayList<Transaction> findByEnterprise(Long id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return transactionRepository.findByEnterprise(id);
    }
}
