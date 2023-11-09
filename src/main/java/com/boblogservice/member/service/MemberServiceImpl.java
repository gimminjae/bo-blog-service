package com.boblogservice.member.service;

import com.boblogservice.member.dto.MemberDto;
import com.boblogservice.member.dto.SignUpDto;
import com.boblogservice.member.entity.Member;
import com.boblogservice.member.exception.NotCorrectTwoPasswordException;
import com.boblogservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String NOT_CORRECT_TWO_PASSWORD = "두 개의 비밀번호가 일치하지 않습니다.";

    @Override
    public void signUp(SignUpDto signUpDto) {
        if(!signUpDto.getPassword1().equals(signUpDto.getPassword2())) {
            throw new NotCorrectTwoPasswordException(NOT_CORRECT_TWO_PASSWORD);
        }
        signUpDto.setPassword1(passwordEncoder.encode(signUpDto.getPassword1()));
        Member member = Member.from(MemberDto.from(signUpDto));
        memberRepository.save(member);
    }

    @Override
    public Map<String, String> login() {
        return null;
    }
}
