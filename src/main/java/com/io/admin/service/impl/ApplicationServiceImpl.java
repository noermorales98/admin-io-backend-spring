package com.io.admin.service.impl;

import com.io.admin.model.*;
import com.io.admin.repository.*;
import com.io.admin.service.ApplicationService;
import com.io.admin.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    //####################### CRUD #################################################

    //TODO CREATE
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
    public Workgroup addWorkgroup(Workgroup workgroup) {
        return workgroupRepository.save(workgroup);
    }




    //TODO READ
    @Override
    public Optional<Member> getMember(long memberID) {
        return memberRepository.findById((int) memberID);
    }

    @Override
    public List<Member> memberlist(){
        Iterable<Member> members = memberRepository.findAll();
        List<Member> members1 = new ArrayList<Member>();
        members.forEach(members1::add);
        return members1;
    }

    @Override
    public Optional<Administrator> getAdmin(long id) {
        return adminRepository.findById((int) id);
    }

    @Override
	public List<Administrator> adminlist() {
		Iterable<Administrator> admin = adminRepository.findAll();
        List<Administrator> administrators = new ArrayList<Administrator>();
        admin.forEach(administrators::add);
        return administrators;
	}

    @Override
    public Optional<Work> getWork(long workid) {
        return workRepository.findById((int) workid);
    }

    @Override
    public List<Work> worklist() {
        Iterable<Work> work = workRepository.findAll();
        List<Work> works = new ArrayList<Work>();
        work.forEach(works::add);
        return works;
    }

    @Override
    public Optional<Workgroup> getWorkgroup(int wgID) {
        return workgroupRepository.findById(wgID);
    }

    @Override
    public List<Workgroup> workgroupList() {
        Iterable<Workgroup> workgroup = workgroupRepository.findAll();
        List<Workgroup> workgroups = new ArrayList<Workgroup>();
        workgroup.forEach(workgroups::add);
        return workgroups;
    }

    //TODO UPDATE
    @Override
    public void updateMember(int memberID) {
        //codigo
    }


    //TODO DELETE
    @Override
    public String deleteMember(int memberID) {
        memberRepository.deleteById(memberID);
        return "Borrado";
    }

    @Override
    public void deleteAdmin(int adminID) {
        adminRepository.deleteById(adminID);
    }

    @Override
    public void deleteWork(int workID) {
        workRepository.deleteById(workID);
    }

    @Override
    public void deleteWorkgroup(int workgroupID) {
        workgroupRepository.deleteById(workgroupID);
    }


}
