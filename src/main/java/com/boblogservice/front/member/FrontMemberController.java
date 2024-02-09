package com.boblogservice.front.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class FrontMemberController {
    @GetMapping
    public String signUp() {
        return "member/signUp";
    }
}
