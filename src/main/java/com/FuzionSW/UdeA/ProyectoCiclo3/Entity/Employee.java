package com.FuzionSW.UdeA.ProyectoCiclo3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Autoincrement
    private long id;
    private String name;
    private String email;

    RoleName role;

    @ManyToOne
    @JoinColumn(name = "enterprise_id") //Name unification with Enterprise table
    Enterprise enterprise;

    public Employee() {
    }

    public Employee(long id, String name, String email, RoleName role, Enterprise enterprise) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.enterprise = enterprise;
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

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
