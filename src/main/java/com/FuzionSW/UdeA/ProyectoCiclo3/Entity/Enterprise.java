package com.FuzionSW.UdeA.ProyectoCiclo3.Entity;

import javax.persistence.*;

@Entity //Anotación de la entidad para gestión de base de datos (BD)
@Table(name = "Enterprise")  //Tabla conectada en la base de Datos con su nombre.

public class Enterprise {
    @Id //Se necesita la llave primaria, tag de base primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //Identificador automatico para la base de datos
    //AUTO proveniente del Enum. Autoincrementa el valor de la tabla

    private long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    //User por crear
    //Transaction procrear
    //Fecha de creacion
    //Frecha de actualizacion


    public Enterprise() {
    }

    public Enterprise(String name, String document, String phone, String address) {
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
}
