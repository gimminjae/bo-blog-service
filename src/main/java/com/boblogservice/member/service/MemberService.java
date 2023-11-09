package com.boblogservice.member.service;

import java.util.Map;

import com.boblogservice.member.dto.LoginDto;
import com.boblogservice.member.dto.SignUpDto;

public interface MemberService {

    void signUp(SignUpDto signUpDto);

    Map<String, String> login(LoginDto loginDto);

    void confirmMemberByNickname(String nickname);

    void confirmMemberByUsername(String username);
}
