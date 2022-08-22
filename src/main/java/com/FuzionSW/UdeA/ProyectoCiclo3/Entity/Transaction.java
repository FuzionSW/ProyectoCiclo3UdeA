package com.FuzionSW.UdeA.ProyectoCiclo3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String concept;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    Enterprise enterprise;

    public Transaction() {
    }
    public Transaction(long id, String concept, double amount, Employee employee, Enterprise enterprise) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
        this.enterprise = enterprise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
