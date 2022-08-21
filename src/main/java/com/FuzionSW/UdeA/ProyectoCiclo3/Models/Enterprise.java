package com.FuzionSW.UdeA.ProyectoCiclo3.Models;

import javax.persistence.*;

@Entity //Es una anotación de la entidad para la gestión de la base de datos.
@Table(name="Enterprise")
public class Enterprise {
    @Id // Anotación de la llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incrementable.
    private int id; // Es el identificador en la base de datos
    private String name;
    private String document;
    private String phone;
    private String address;

    public Enterprise() {
    }

    public Enterprise(String name, String document, String phone, String addrees) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = addrees;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addrees) {
        this.address = addrees;
    }
}