package com.FuzionSW.UdeA.ProyectoCiclo3.Entity;

import javax.persistence.*;

@Entity                                                 // Anotación de la entidad para la gestión de la BD
@Table(name = "Enterprise")
public class Enterprise {
    @Id                                                 // Anotación de Clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)     // Autoincrementable
    private long id;                                     // en la base de datos
    private String name;
    private String address;
    private String phone;
    private String document;

    public Enterprise() {
    }

    public Enterprise(String nombre, String direccion, String phone, String NIT) {
        this.name = nombre;
        this.address = direccion;
        this.phone = phone;
        this.document = NIT;
    }

    public long getId() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}


