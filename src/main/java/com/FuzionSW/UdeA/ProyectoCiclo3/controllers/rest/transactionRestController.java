package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.rest;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.transaction.TransactionNotFoundException;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.transaction.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class transactionRestController {
    private final TransactionService transactionService;

    public transactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping({"/movements/{id}"})
    public Transaction getMovement(@PathVariable long id) throws TransactionNotFoundException {
        return this.transactionService.getTransaction(id);
    }

    @GetMapping({"/movements"})
    public List<Transaction> getMovements(@PathVariable long id) throws TransactionNotFoundException {
        return this.transactionService.getTransactionList();
    }

    @GetMapping({"/enterprises/{id}/movements"})
    public ArrayList<Transaction> getEnterpriseMovement(@PathVariable long id) throws TransactionNotFoundException {
        return this.transactionService.findByEnterprise(id);
    }

    @PostMapping({"/enterprises/{id}/movements"})
    public Transaction postMovement(@RequestBody Transaction transaction){
        return this.transactionService.createTransaction(transaction);
    }

    @PatchMapping(path = "/enterprises/{id}/movements")
    public ResponseEntity<Transaction> updateEmployee(@PathVariable Long id, @RequestBody Transaction transaction) {
        try {
            Transaction transactionUpdated = transactionService.getTransaction(id);
            transactionUpdated.setConcept(transaction.getConcept());
            transactionUpdated.setAmount(transaction.getAmount());
            transactionUpdated.setEnterprise(transaction.getEnterprise());
            transactionUpdated.setCreatedAt(transactionUpdated.getCreatedAt());
            transactionUpdated.setUpdatedAt(transactionUpdated.getUpdatedAt());
            transactionService.saveTransaction(transactionUpdated);
            return ResponseEntity.ok(transactionUpdated);
        } catch (TransactionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping({"/enterprises/{id}/movements"})
    public ResponseEntity<Long> deleteMovement(@PathVariable Long id) throws TransactionNotFoundException {
        boolean isRemoved = this.transactionService.isTransactionDeleted(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
