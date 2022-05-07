package com.example.vanlosealle82.Controller;

import com.example.vanlosealle82.Model.Member;
import com.example.vanlosealle82.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    MemberService service;

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("addNewMember")
    public String newMember(){
        return "addNewMember";
    }
    @PostMapping("addNewMember")
    public String newMember(@ModelAttribute Member member){
        service.addNew(member);
        return "redirect:/";
    }

    @GetMapping("/cleaningIndex")
    public String cleaningIndex(){
        return "cleaningIndex";
    }


}
