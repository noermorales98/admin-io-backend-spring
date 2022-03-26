package com.io.admin.controller;

import com.io.admin.model.*;
import com.io.admin.service.ApplicationService;
import com.io.admin.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/adminapi/v1")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;


    @ExceptionHandler({ BusinessException.class })
    @ResponseBody
    public ResponseEntity<String> userHandler(BusinessException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }

    //prueba
    @GetMapping("")
    public String inicio(){return applicationService.firstService();}

    //#############################################################
    //################  BASE DE DATOS ADMIN.IO  ###################
    //#############################################################

    //TODO CREATE
    //CREAR MEMBERS
    @RequestMapping(value = "/createMember", method = RequestMethod.POST)
    public ResponseEntity<Member> create(@RequestBody Member member){
        Member member1 = applicationService.addMember(member);
        return new ResponseEntity(member1, HttpStatus.CREATED);
    }
    //CREAR ADMIN
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
    public ResponseEntity<Administrator> addAdmin(@RequestBody Administrator administrator){
        Administrator administrator1 = applicationService.addAdmin(administrator);
        return new ResponseEntity(administrator1, HttpStatus.CREATED);
    }
    //CREAR WORK
    @RequestMapping(value = "/createWork", method = RequestMethod.POST)
    public ResponseEntity<Work> addWork(@RequestBody Work work){
        Work work1 = applicationService.addWork(work);
        return new ResponseEntity(work, HttpStatus.CREATED);
    }
    //CREAR WORKGROUP
    @RequestMapping(value = "/createWorkgroup", method = RequestMethod.POST)
    public ResponseEntity<Workgroup> addWorkgroup(@RequestBody Workgroup workgroup){
        Workgroup workgroup2 = applicationService.addWorkgroup(workgroup);
        return new ResponseEntity(workgroup, HttpStatus.OK);
    }
    //CREAR RELACION WORK AND GROUP


    //TODO READ
    //member
    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    public ResponseEntity<Member> userById(@RequestParam(value = "id") long id) {
        Optional<Member> user = applicationService.getMember(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/getMembers", method = RequestMethod.GET)
    public ResponseEntity<Member> memberList(){
        List<Member> members = applicationService.memberlist();
        return new ResponseEntity(members, HttpStatus.OK);
    }
    //admin
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    public ResponseEntity<Administrator> adminById(@RequestParam(value = "id") long id){
        Optional<Administrator> admin = applicationService.getAdmin(id);
        return new ResponseEntity(admin, HttpStatus.OK);
    }
    @RequestMapping(value="/getAdmins", method = RequestMethod.GET)
    public ResponseEntity<Administrator> adminlist(){
        List<Administrator> administrators = applicationService.adminlist();
        return new ResponseEntity(administrators, HttpStatus.OK);
    }
    //work
    @RequestMapping(value = "/getWork", method = RequestMethod.GET)
    public ResponseEntity<Work> workById(@RequestParam(value = "id") long workid){
        Optional<Work> work = applicationService.getWork(workid);
        return new ResponseEntity(work, HttpStatus.OK);
    }
    @RequestMapping(value = "/getWorks", method = RequestMethod.GET)
    public ResponseEntity<Work> worklist(){
        List<Work> works = applicationService.worklist();
        return new ResponseEntity(works, HttpStatus.OK);
    }
    //workgroups
    @RequestMapping(value = "/getWorkgroup", method = RequestMethod.GET)
    public ResponseEntity<Workgroup> workgroupById(@RequestParam(value = "id") long workgroupid){
        Optional<Workgroup> work = applicationService.getWorkgroup((int)workgroupid);
        return new ResponseEntity(work, HttpStatus.OK);
    }
    @RequestMapping(value = "/getWorkgroups", method = RequestMethod.GET)
    public ResponseEntity<Workgroup> workgrouplist(){
        List<Workgroup> workgroups = applicationService.workgroupList();
        return new ResponseEntity(workgroups, HttpStatus.OK);
    }

    //TODO UPDATE


    //TODO DELETE
    @RequestMapping(value = "/deleteMember")
    public String deleteMember(@RequestBody Member id){
        //Optional<Member> m1 = applicationService.getMember(id);
        System.out.println(id);
        /*if(m1.isEmpty()){
            return "no existe";
        }*/
        /*else{

        }*/
        applicationService.deleteMember(id);
        return "borrado";
    }
    @RequestMapping(value = "/deleteAdmin")
    public String deleteAdmin(@RequestParam(value = "id") int id){
        Optional<Administrator> administrator = applicationService.getAdmin(id);
        if (administrator.isEmpty()){
            return "no existe";
        }
        else {
            applicationService.deleteAdmin(id);
            return "Borrado";
        }
    }
    @RequestMapping(value = "/deleteWork")
    public String deleteWork(@RequestBody Work id){
        applicationService.deleteWork(id);
        return "Borrado";
    }
    @RequestMapping(value = "/deleteWorkgroup")
    public String deleteWorkgroup(@RequestParam(value = "id")int id){
        Optional<Workgroup> workgroup = applicationService.getWorkgroup(id);
        if (workgroup.isEmpty()){
            return "No existe";
        }
        else {
            applicationService.deleteWorkgroup(id);
            return "Borrado";
        }
    }
}
