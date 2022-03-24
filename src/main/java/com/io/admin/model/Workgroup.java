package com.io.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_workgroup;
    String name_workgroup;
    String description_workgroup;
    int administrator_id_administrator;


    public Workgroup() {
    }

    public int getId_workgroup() {
        return id_workgroup;
    }

    public void setId_workgroup(int id_workgroup) {
        this.id_workgroup = id_workgroup;
    }

    public String getName_workgroup() {
        return name_workgroup;
    }

    public void setName_workgroup(String name_workgroup) {
        this.name_workgroup = name_workgroup;
    }

    public String getDescription_workgroup() {
        return description_workgroup;
    }

    public void setDescription_workgroup(String description_workgroup) {
        this.description_workgroup = description_workgroup;
    }

    public int getAdministrator_id_administrator() {
        return administrator_id_administrator;
    }

    public void setAdministrator_id_administrator(int administrator_id_administrator) {
        this.administrator_id_administrator = administrator_id_administrator;
    }

}
