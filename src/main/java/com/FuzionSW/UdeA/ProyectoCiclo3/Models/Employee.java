package com.FuzionSW.UdeA.ProyectoCiclo3.Models;

import javax.persistence.*;

@Entity //Es una anotación de la entidad para la gestión de la base de datos.
@Table(name="Employee")
public class Employee {
    @Id // Anotación de la llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incrementable.
    private int id; // Es el identificador en la base de datos
    private String name;
    private String email;
    private String enterprise;
    private String role;

    public Employee() {
    }

    public Employee(String name, String email, String enterprise, String role) {
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
