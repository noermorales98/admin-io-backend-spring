package com.io.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_work;
    String name_work;
    String description_work;
    String priority_work;
    String process_work;
    Date startdate_work;
    Date enddate_work;

    public Work() {
    }

    public int getId_work() {
        return id_work;
    }

    public void setId_work(int id_work) {
        this.id_work = id_work;
    }

    public String getName_work() {
        return name_work;
    }

    public void setName_work(String name_work) {
        this.name_work = name_work;
    }

    public String getDescription_work() {
        return description_work;
    }

    public void setDescription_work(String description_work) {
        this.description_work = description_work;
    }

    public String getPriority_work() {
        return priority_work;
    }

    public void setPriority_work(String priority_work) {
        this.priority_work = priority_work;
    }

    public String getProcess_work() {
        return process_work;
    }

    public void setProcess_work(String process_work) {
        this.process_work = process_work;
    }

    public Date getStartdate_work() {
        return startdate_work;
    }

    public void setStartdate_work(Date startdate_work) {
        this.startdate_work = startdate_work;
    }

    public Date getEnddate_work() {
        return enddate_work;
    }

    public void setEnddate_work(Date enddate_work) {
        this.enddate_work = enddate_work;
    }
}
