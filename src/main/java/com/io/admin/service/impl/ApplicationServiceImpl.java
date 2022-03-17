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

    //01) yes "/testHttp"
    @Override
    public BeeceptorDTO testHttp() throws IOException {
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(httpService.sendRequestHttpS("https://equiponoe.free.beeceptor.com/","GET",null,null,"json",null, null));
        BeeceptorDTO beeceptorDTO = new BeeceptorDTO();
        if(json.get("status")== null){
            throw new BusinessException("Code doesn´t exist", HttpStatus.FORBIDDEN);
        }
        beeceptorDTO.setCode(json.get("status").getAsString());
        beeceptorDTO.setMessage(json.get("id").getAsString());
        beeceptorDTO.setStatus(json.get("name").getAsString());
        return beeceptorDTO;
    }

    //02 yes "/noe"
    @Override
    public NoeliDTO noe() throws  IOException{
        JsonParser par = new JsonParser();
        JsonObject json = (JsonObject) par.parse(httpService.sendRequestHttpS("https://equiponoe.free.beeceptor.com","GET",null,null,"json",null, null));
        NoeliDTO noeDTO = new NoeliDTO();
        noeDTO.setName_workgroup(json.get("status").getAsString());
        noeDTO.setDescription_workgroup(json.get("name").getAsString());
        return noeDTO;
    }


    //03 yes "/youtubeitem"
    @Override
    public YouTubeMergeDTO mergeYoutube() throws IOException {
        YouTubeMergeDTO yd = new YouTubeMergeDTO();
        JsonParser pr = new JsonParser();
        JsonObject json = (JsonObject) pr.parse(httpService.sendRequestHttpS("https://www.googleapis.com/youtube/v3/videos?id=FUJDBXaKBcA&key=AIzaSyC-XbXXpngMiW6CFfPUsoZvQpcuki6nYvI&part=snippet","GET",null,null,"json",null, null));
        yd.setKind(json.get("kind").getAsString());
        yd.setEtag(json.get("etag").getAsString());
        JsonArray listas = json.getAsJsonArray("items");
        List<YouTubeItemsDTO> youtubeDTOList = new ArrayList<>();
        for(int x = 0 ; x > listas.size(); x++){
            JsonObject job1 = listas.get(x).getAsJsonObject();
            YouTubeItemsDTO y1 = new YouTubeItemsDTO();
            y1.setKind(job1.get("kind").getAsString());
            y1.setEtag(job1.get("etag").getAsString());
            y1.setId(job1.get("id").getAsString());
            YouTubeSnippetDTO snippetDTO = new YouTubeSnippetDTO();
            JsonObject snippetobject = job1.get("snippet").getAsJsonObject();
            snippetDTO.setPublishedAt(snippetobject.get("publishedAt").getAsString());
            snippetDTO.setChannelId(snippetobject.get("channelId").getAsString());
            snippetDTO.setTitle(snippetobject.get("title").getAsString());
            snippetDTO.setDescription(snippetobject.get("description").getAsString());
            y1.setSnippetDTO(snippetDTO);
            youtubeDTOList.add(y1);
        }
        yd.setYoutubelista(youtubeDTOList);
        return yd;
    }

    //04 yes BD Members
    @Override
    public void ejemplo() throws IOException {
        Member workgroup = new Member();
        workgroup.setName_member("Noeli");
        workgroup.setEmail_member("noeliss@gmail.com");
        workgroup.setDescription_member("asas");
        workgroup.setPassword_member("asasas");
        memberRepository.save(workgroup);
    }

    @Override
    public void addMembers(Member member) {

    }

    @Override
    public NoeliDTO noepostHttp(NoeliDTO noeliDTO) throws IOException {
        JsonParser pri = new JsonParser();
        JsonObject json = (JsonObject) pri.parse(httpService.sendRequestHttpS("https://equiponoe.free.beeceptor.com/api/v1/noepostHttp","POST",null,null,"json",noeliDTO.toJSON(), null));
        if(json.get("status")== null){
            throw new BusinessException("status doesn´t exist", HttpStatus.FORBIDDEN);
        }
        if(json.get("name")== null){
            throw new BusinessException("name no found", HttpStatus.FORBIDDEN);
        }
        if(json.get("id")== null){
            throw new BusinessException("status no found", HttpStatus.FORBIDDEN);
        }
        return noeliDTO;
    }

    //CASI FUNCIONAL, NO GUARDA DATOS EN BD
    @Override
    public MemberDTO addMemberDTO(MemberDTO memberDTO) throws IOException{
        JsonParser p1 = new JsonParser();
        JsonObject json = (JsonObject) p1.parse(httpService.sendRequestHttpS("https://addmember.free.beeceptor.com","POST",null,null,"json",memberDTO.toJSON(), null));
        System.out.println(json.get("status"));
        if(json.get("status")== null){
            throw new BusinessException("status doesn´t exist", HttpStatus.FORBIDDEN);
        }
        if(json.get("name")== null){
            throw new BusinessException("name no found", HttpStatus.FORBIDDEN);
        }
        if(json.get("id")== null){
            throw new BusinessException("status no found", HttpStatus.FORBIDDEN);
        }
        memberDTO.setDescription_member(String.valueOf(json.get("status")));
        memberDTO.setEmail_member(String.valueOf(json.get("name")));
        memberDTO.setName_member(String.valueOf(json.get("name")));
        String phone = String.valueOf(json.get("phone"));
        memberDTO.setPhone_member(Integer.parseInt(phone));
        memberDTO.setPassword_member(String.valueOf(json.get("passwd")));
        return  memberDTO;
    }

    public void myObjectNoe(){
        Member usury = new Member();
        usury.setName_member("Noeli");
        usury.setEmail_member("asasas");
        usury.setPassword_member("asas");
        usury.setPhone_member(1199);
        memberRepository.save(usury);
    }

    public void saveMembers(MemberDTO memberDTO) throws IOException{
        Member m1 = new Member();
        m1.setPhone_member(memberDTO.getPhone_member());
        m1.setDescription_member(memberDTO.getDescription_member());
        m1.setEmail_member(memberDTO.getEmail_member());
        m1.setName_member(memberDTO.getName_member());
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
}
