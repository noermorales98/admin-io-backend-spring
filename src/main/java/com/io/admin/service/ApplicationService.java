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
//ji
@Service
public interface ApplicationService {
    String firstService();
    BeeceptorDTO testHttp() throws IOException;
    NoeliDTO noe() throws  IOException;
    //APIS
    YouTubeMergeDTO mergeYoutube() throws IOException;
    void ejemplo() throws IOException;
    public void addMembers(@RequestBody Member member);

    //POST
    NoeliDTO noepostHttp(NoeliDTO noeliDTO) throws  IOException;

    MemberDTO addMemberDTO(MemberDTO memberDTO) throws IOException;

    void myObjectNoe();
    void saveMembers(MemberDTO memberDTO) throws IOException;

    //BASE DE DATOS ADMIN.IO
    //CREATE
    Member addMember(Member member);
    Administrator addAdmin(Administrator administrator);
    Work addWork(Work work);
}
