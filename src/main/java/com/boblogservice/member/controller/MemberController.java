package com.boblogservice.member.controller;

import com.boblogservice.common.exception.FormValidationException;
import com.boblogservice.common.validation.ValidationUtil;
import com.boblogservice.member.dto.LoginDto;
import com.boblogservice.member.dto.SignUpDto;
import com.boblogservice.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpDto signUpDto, BindingResult bindingResult) {
        ValidationUtil.confirmError(bindingResult);
        memberService.signUp(signUpDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/nickname")
    public ResponseEntity<Void> confirmNickname(@RequestParam String nickname) {
        memberService.confirmMemberByNickname(nickname);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/username")
    public ResponseEntity<Void> confirmUsername(@RequestParam String username) {
        memberService.confirmMemberByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody @Valid LoginDto LoginDto) {
        return new ResponseEntity<>(memberService.login(), HttpStatus.OK);
    }
}
