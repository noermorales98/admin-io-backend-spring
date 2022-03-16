package com.io.admin.model;

//haciendo las relaciones entre grupos y administradores
public class Workgroup_has_administrador {
    int workgroup_id_workgroup;
    int administrator_id_administrator;

    public Workgroup_has_administrador() {
    }

    public int getWorkgroup_id_workgroup() {
        return workgroup_id_workgroup;
    }

    public void setWorkgroup_id_workgroup(int workgroup_id_workgroup) {
        this.workgroup_id_workgroup = workgroup_id_workgroup;
    }

    public int getAdministrator_id_administrator() {
        return administrator_id_administrator;
    }

    public void setAdministrator_id_administrator(int administrator_id_administrator) {
        this.administrator_id_administrator = administrator_id_administrator;
    }
}
