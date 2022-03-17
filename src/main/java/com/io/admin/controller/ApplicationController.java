package com.io.admin.controller;

import com.io.admin.dto.users.BeeceptorDTO;
import com.io.admin.dto.youtube.YouTubeMergeDTO;
import com.io.admin.model.Administrator;
import com.io.admin.model.Member;
import com.io.admin.model.Work;
import com.io.admin.service.ApplicationService;
import com.io.admin.dto.users.*;
import com.io.admin.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping(value = "/api/v1",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;


    @ExceptionHandler({ BusinessException.class })
    @ResponseBody
    public ResponseEntity<String> userHandler(BusinessException ex) {
        return new ResponseEntity<String>(ex.getMessage(), ex.getHttpStatus());
    }

    //##########################################################
    //##############    GETMAPPING    #########################
    //##########################################################

    //prueba
    @GetMapping("")
    public String inicio(){return applicationService.firstService();}

    /*################# //01 test del programa #############################*/
    @GetMapping("/testHttp")
    public BeeceptorDTO testHttp() throws IOException {
        return applicationService.testHttp();
    }
    /*################### //02 test beeceptor #############################*/
    @GetMapping("/noe")
    public NoeliDTO noe() throws IOException {
        return applicationService.noe();
    }
    /*###################### //03 youtube ################################*/
    @GetMapping("/youtubeitem")
    public YouTubeMergeDTO youTubeDTO() throws IOException {
        YouTubeMergeDTO yd = applicationService.mergeYoutube();
        return yd;
    }
    /*################## //04 ejemplo BD Members ####################################*/
    @GetMapping("/ejemplo")
    public void yo() throws  IOException{
        applicationService.ejemplo();
    }

    //##########################################################
    //##############    POSTMAPPING    #########################
    //##########################################################

    //01
    @PostMapping("/addMembers")
    public void addMembers(@RequestBody Member member){
        applicationService.addMembers(member);
    }
    //PRUEBA DOS POST
    @PostMapping("/testPostHttpNoe")
    public NoeliDTO noeli(@RequestBody NoeliDTO noeliDTO) throws IOException {
        NoeliDTO nrm = applicationService.noepostHttp(noeliDTO);
        applicationService.myObjectNoe();
        return nrm;
    }

    //CASI FUNCIONAL, NO GUARDA DATOS EN BD
    @PostMapping("/saveMembers")
    public MemberDTO miembro(@RequestBody MemberDTO memberDTO) throws  IOException{
        MemberDTO m1 = applicationService.addMemberDTO(memberDTO);
        //applicationService.saveMembers(m1);
        return m1;
    }

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
}
