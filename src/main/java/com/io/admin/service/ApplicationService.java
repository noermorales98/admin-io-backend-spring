package com.io.admin.service;

import com.io.admin.dto.users.BeeceptorDTO;
import com.io.admin.dto.users.NoeliDTO;
import com.io.admin.dto.youtube.YouTubeMergeDTO;
import com.io.admin.model.Member;
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

    void myObjectNoe();
}
