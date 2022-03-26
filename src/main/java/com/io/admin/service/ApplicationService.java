package com.io.admin.service;

import com.io.admin.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ApplicationService {
    String firstService();

    //BASE DE DATOS ADMIN.IO
    //#################### CRUD #######################33
    //TODO CREATE
    Member addMember(Member member);
    Administrator addAdmin(Administrator administrator);
    Work addWork(Work work);
    Workgroup addWorkgroup(Workgroup workgroup);

    //TODO READ
    Optional<Member> getMember(long memberID);
    List<Member> memberlist();

    Optional<Administrator> getAdmin(long id);
    List<Administrator> adminlist();
    
    Optional<Work> getWork(long workid);
    List<Work> worklist();
    
    Optional<Workgroup> getWorkgroup(int wgID);
    List<Workgroup> workgroupList();

    //TODO UPDATE
    void updateMember(int memberID);

    //TODO DELETE
    String deleteMember(Member memberID);
    void deleteAdmin(int adminID);
    void deleteWork(Work workID);
    void deleteWorkgroup(int workgroupID);

    

    
}
