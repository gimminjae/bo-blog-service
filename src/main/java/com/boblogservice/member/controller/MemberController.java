package com.boblogservice.member.controller;

import com.boblogservice.common.exception.FormValidationException;
import com.boblogservice.common.validation.ValidationUtil;
import com.boblogservice.member.dto.LoginDto;
import com.boblogservice.member.dto.SignUpDto;
import com.boblogservice.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Tag(name = "MemberController API", description = "member")
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "sign up - 회원가입", description = "")
    @PostMapping("")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpDto signUpDto, BindingResult bindingResult) {
        ValidationUtil.confirmError(bindingResult);
        memberService.signUp(signUpDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "confirm member by nickname - 닉네임 중복 확인", description = "")
    @Parameter(name = "nickname", description = "nickname - 닉네임")
    @GetMapping("/nickname")
    public ResponseEntity<Void> confirmNickname(@RequestParam String nickname) {
        memberService.confirmMemberByNickname(nickname);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "confirm member by username - 아이디 중복 확인", description = "")
    @Parameter(name = "username", description = "username - 아이디")
    @GetMapping("/username")
    public ResponseEntity<Void> confirmUsername(@RequestParam String username) {
        memberService.confirmMemberByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "sign in - 로그인", description = "")
    @Parameter(name = "username", description = "username - 아이디")
    @Parameter(name = "password", description = "password - 비밀번호")
    @GetMapping("/sign-in")
    public ResponseEntity<Map<String, String>> signIn(@Valid LoginDto loginDto, BindingResult bindingResult) {
        return new ResponseEntity<>(memberService.login(loginDto), HttpStatus.OK);
    }
}
