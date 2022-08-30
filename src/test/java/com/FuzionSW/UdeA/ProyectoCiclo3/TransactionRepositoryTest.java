package com.FuzionSW.UdeA.ProyectoCiclo3;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.RoleName;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EmployeeRepository;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EnterpriseRepository;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void  testAddNewTransaction(){

        Transaction transaction = new Transaction();
        transaction.setConcept("Ingreso 1");
        transaction.setAmount(50000);

        Employee employee = new Employee();
        employee.setName("Juan");
        employee.setEmail("juan@gmail.com");

        Enterprise enterprise = new Enterprise();
        enterprise.setName("La 14");
        enterprise.setDocument("81238456-8");
        enterprise.setPhone("3103103102");
        enterprise.setAddress("Calle 14");
        Enterprise savedEnterprise = enterpriseRepository.save(enterprise);
        transaction.setEnterprise(enterprise);

        employee.setEnterprise(enterprise);
        employee.setRole(RoleName.ADMIN);
        Employee savedEmployee = employeeRepository.save(employee);
        transaction.setUser(employee);

        transaction.setCreatedAt(LocalDate.now());
        transaction.setUpdatedAt(LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);

        Transaction existTransaction = entityManager.find(Transaction.class, savedTransaction.getId());
        Employee existEmployee = entityManager.find(Employee.class, savedEmployee.getId());
        assertThat(existTransaction.getId()).isEqualTo(transaction.getId());
    }

    @Test
    public void testListAllTransactions() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        assertThat(transactions).hasSizeGreaterThan(0);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Test
    public void testUpdateTransaction() {
        long transactionId = 1;
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        Transaction transaction = optionalTransaction.get();
        transaction.setAmount(-70000);
        transaction.setUpdatedAt(LocalDateTime.now());
        transactionRepository.save(transaction);

        Transaction updatedTransaction = transactionRepository.findById(transactionId).get();
        assertThat(updatedTransaction.getAmount()).isEqualTo(transaction.getAmount());
    }

    @Test
    public void testGetTransaction(){
        long transactionId = 1;
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);

        assertThat(optionalTransaction).isPresent();
        System.out.println(optionalTransaction.get());
    }

    @Test
    public void testDeleteTransaction(){
        long transactionId = 1;
        transactionRepository.deleteById(transactionId);

        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        assertThat(optionalTransaction).isNotPresent();
    }
}
