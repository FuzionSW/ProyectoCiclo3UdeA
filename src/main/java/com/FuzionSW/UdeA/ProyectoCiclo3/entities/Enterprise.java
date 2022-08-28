package com.FuzionSW.UdeA.ProyectoCiclo3.entities;

import javax.persistence.*;

@Entity
@Table(name = "Enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false, length = 45)
    private String address;

    public Enterprise() {
    }

    public Enterprise(String name, String document, String phone, String address) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
    }

    public Enterprise(long id, String name, String document, String phone, String address) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
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

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

