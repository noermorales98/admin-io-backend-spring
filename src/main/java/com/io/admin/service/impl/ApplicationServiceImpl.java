package com.io.admin.service.impl;

import com.io.admin.model.Administrator;
import com.io.admin.model.Member;
import com.io.admin.model.Work;
import com.io.admin.model.Workgroup;
import com.io.admin.repository.AdminRepository;
import com.io.admin.repository.WorkRepository;
import com.io.admin.repository.WorkgroupRepository;
import com.io.admin.service.ApplicationService;
import com.io.admin.service.HttpService;
import com.io.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    WorkgroupRepository workgroupRepository;

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

    @Override
    public Optional<Administrator> getAdmin(long id) {
        return adminRepository.findById((int) id);
    }

    @Override
    public Optional<Work> getWork(long workid) {
        return workRepository.findById((int) workid);
    }

    @Override
    public Optional<Workgroup> getWorkgroup(int wgID) {
        return workgroupRepository.findById(wgID);
    }
}
