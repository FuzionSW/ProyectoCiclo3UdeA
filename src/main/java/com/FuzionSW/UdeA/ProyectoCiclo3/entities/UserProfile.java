package com.FuzionSW.UdeA.ProyectoCiclo3.entities;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "auth0Id", unique = true)
    private String auth0Id;

    @Column(name = "email")
    private String email;

    @Column(name = "image", unique = true)
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "given_name")
    private String given_name;

    @Column(name = "nickname")
    private String nickname;

    public UserProfile() {
    }

    public UserProfile(String auth0Id, String email, String image, String name, String given_name, String nickname) {
        this.auth0Id = auth0Id;
        this.email = email;
        this.image = image;
        this.name = name;
        this.given_name = given_name;
        this.nickname = nickname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
