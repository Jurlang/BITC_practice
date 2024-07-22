package com.mysite.boot01_ajax.controller;

import com.mysite.boot01_ajax.dto.MemberJoinDTO;
import com.mysite.boot01_ajax.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void loginGet(String error, String logout){
        log.info("login get................");
        log.info("logout : " + logout);

        if(logout != null){
            log.info("user logout..............");
        }
    }

    @GetMapping("/join")
    public void joinGet(){
        log.info("join get ......");
    }

    @PostMapping("/join")
    public String joinPost(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes){
        log.info("join post ......");
        log.info(memberJoinDTO);

        try{
            memberService.join(memberJoinDTO);
        }catch(MemberService.MidExistException e){
            redirectAttributes.addFlashAttribute("error", "mid");
            return "redirect:/member/join";
        }

        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/member/login";
    }

}
