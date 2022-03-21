package com.io.admin.service;

import com.io.admin.dto.users.BeeceptorDTO;
import com.io.admin.dto.users.MemberDTO;
import com.io.admin.dto.users.NoeliDTO;
import com.io.admin.dto.youtube.YouTubeMergeDTO;
import com.io.admin.model.Administrator;
import com.io.admin.model.Member;
import com.io.admin.model.Work;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Optional;

//ji
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
}
