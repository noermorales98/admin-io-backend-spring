package com.io.admin.service;

import com.io.admin.model.Administrator;
import com.io.admin.model.Member;
import com.io.admin.model.Work;
import com.io.admin.model.Workgroup;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ApplicationService {
    String firstService();

    //BASE DE DATOS ADMIN.IO
    //#################### CRUD #######################33
    //CREATE
    Member addMember(Member member);
    Administrator addAdmin(Administrator administrator);
    Work addWork(Work work);

    //READ
    Optional<Member> getMember(long memberID);
    Optional<Administrator> getAdmin(long id);
    Optional<Work> getWork(long workid);
    Optional<Workgroup> getWorkgroup(int wgID);

    //UPDATE

    //DELETE
    String deleteMember(int memberID);
}
