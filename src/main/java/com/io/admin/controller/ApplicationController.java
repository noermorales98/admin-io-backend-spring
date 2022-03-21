package com.io.admin.controller;

import com.io.admin.model.Administrator;
import com.io.admin.model.Member;
import com.io.admin.model.Work;
import com.io.admin.service.ApplicationService;
import com.io.admin.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/adminapi/v1",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
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

    //CREAR MEMBERS
    @RequestMapping(value = "/createMember", method = RequestMethod.POST)
    public ResponseEntity<Member> create(@RequestBody Member member){
        Member member1 = applicationService.addMember(member);
        return new ResponseEntity(member1, HttpStatus.CREATED);
    }
    //CREAR ADMIN
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

    //################ READ ########################################
    //member
    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    public ResponseEntity<Member> userById(@RequestParam(value = "id") long id) {
        Optional<Member> user = applicationService.getMember(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    //admin
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    public ResponseEntity<Administrator> adminById(@RequestParam(value = "id") long id){
        Optional<Administrator> admin = applicationService.getAdmin(id);
        return new ResponseEntity(admin, HttpStatus.OK);
    }
    //work
    @RequestMapping(value = "/getWork", method = RequestMethod.GET)
    public ResponseEntity<Work> workById(@RequestParam(value = "id") long workid){
        Optional<Work> work = applicationService.getWork(workid);
        return new ResponseEntity(work, HttpStatus.OK);
    }

    //################### DELETE
    @RequestMapping(value = "/deleteMember")
    public String deleteMember(@RequestParam(value = "id") int id){
        applicationService.deleteMember(id);
        return "borrado";
    }
}
