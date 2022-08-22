package com.FuzionSW.UdeA.ProyectoCiclo3.Entity;

import javax.persistence.*;

@Entity
@Table(name="Transaction")
public class Transaction {
    @Id // Anotación de la llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incrementable.
    private long id; // Es el identificador en la base de datos

    private String concept;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee user;

    public Transaction() {
    }

    public Transaction(String concept, double amount, Employee user) {
        this.concept = concept;
        this.amount = amount;
        this.user = user;
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

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
