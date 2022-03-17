package com.io.admin.model;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_member;

    String name_member;
    String email_member;
    String password_member;
    int phone_member;
    String description_member;

    public Member() {
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public String getName_member() {
        return name_member;
    }

    public void setName_member(String name_member) {
        this.name_member = name_member;
    }

    public String getEmail_member() {
        return email_member;
    }

    public void setEmail_member(String email_member) {
        this.email_member = email_member;
    }

    public String getPassword_member() {
        return password_member;
    }

    public void setPassword_member(String password_member) {
        this.password_member = password_member;
    }

    public int getPhone_member() {
        return phone_member;
    }

    public void setPhone_member(int phone_member) {
        this.phone_member = phone_member;
    }

    public String getDescription_member() {
        return description_member;
    }

    public void setDescription_member(String description_member) {
        this.description_member = description_member;
    }
}
