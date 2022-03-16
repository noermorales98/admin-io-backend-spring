package com.io.admin.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_administrator;
    String name_administrator;
    String email_administrator;
    String password_administrator;
    int phone_administrator;
    String description_administrator;

    public Administrator() {
    }

    public int getId_administrator() {
        return id_administrator;
    }

    public void setId_administrator(int id_administrator) {
        this.id_administrator = id_administrator;
    }

    public String getName_administrator() {
        return name_administrator;
    }

    public void setName_administrator(String name_administrator) {
        this.name_administrator = name_administrator;
    }

    public String getEmail_administrator() {
        return email_administrator;
    }

    public void setEmail_administrator(String email_administrator) {
        this.email_administrator = email_administrator;
    }

    public String getPassword_administrator() {
        return password_administrator;
    }

    public void setPassword_administrator(String password_administrator) {
        this.password_administrator = password_administrator;
    }

    public int getPhone_administrator() {
        return phone_administrator;
    }

    public void setPhone_administrator(int phone_administrator) {
        this.phone_administrator = phone_administrator;
    }

    public String getDescription_administrator() {
        return description_administrator;
    }

    public void setDescription_administrator(String description_administrator) {
        this.description_administrator = description_administrator;
    }
}
