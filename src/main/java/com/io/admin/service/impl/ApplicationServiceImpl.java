package com.io.admin.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.io.admin.dto.users.BeeceptorDTO;
import com.io.admin.dto.users.MemberDTO;
import com.io.admin.dto.users.NoeliDTO;
import com.io.admin.model.Administrator;
import com.io.admin.model.Member;
import com.io.admin.model.Work;
import com.io.admin.repository.AdminRepository;
import com.io.admin.repository.WorkRepository;
import com.io.admin.service.ApplicationService;
import com.io.admin.service.HttpService;
import com.io.admin.dto.youtube.YouTubeItemsDTO;
import com.io.admin.dto.youtube.YouTubeMergeDTO;
import com.io.admin.dto.youtube.YouTubeSnippetDTO;
import com.io.admin.exception.BusinessException;
import com.io.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    HttpService httpService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    WorkRepository workRepository;
    @Override
    public String firstService(){
        return "Bienvenido";
    }

    @Override
    public Member addMember(Member member){
        return memberRepository.save(member);
    }

    @Override
    public Administrator addAdmin(Administrator administrator) {
        return adminRepository.save(administrator);
    }

    @Override
    public Work addWork(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Optional<Member> getMember(long memberID) {
        return memberRepository.findById((int) memberID);
    }
}
