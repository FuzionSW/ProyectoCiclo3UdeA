package com.FuzionSW.UdeA.ProyectoCiclo3.entities;

import javax.persistence.*;

@Entity //Es una anotación de la entidad para la gestión de la base de datos.
@Table(name="Employee")
public class Employee {
    @Id // Anotación de la llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incrementable.
    private long id; // Es el identificador en la base de datos

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    private RoleName role;

    public Employee() {
    }

    public Employee(String name, String email, Enterprise enterprise, RoleName role) {
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
