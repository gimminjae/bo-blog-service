package com.boblogservice.member.service;

import java.util.Map;

import com.boblogservice.member.dto.SignUpDto;

public interface MemberService {

    void signUp(SignUpDto signUpDto);

    Map<String, String> login();

    void confirmMemberByNickname(String nickname);

    void confirmMemberByUsername(String username);
}
