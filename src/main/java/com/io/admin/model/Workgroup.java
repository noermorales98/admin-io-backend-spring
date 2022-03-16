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
    int member_id_member;
    int work_id_work;

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

    public int getMember_id_member() {
        return member_id_member;
    }

    public void setMember_id_member(int member_id_member) {
        this.member_id_member = member_id_member;
    }

    public int getWork_id_work() {
        return work_id_work;
    }

    public void setWork_id_work(int work_id_work) {
        this.work_id_work = work_id_work;
    }
}
