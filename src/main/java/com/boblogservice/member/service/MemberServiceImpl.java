package com.boblogservice.member.service;

import com.boblogservice.member.dto.LoginDto;
import com.boblogservice.member.dto.MemberDto;
import com.boblogservice.member.dto.SignUpDto;
import com.boblogservice.member.entity.Member;
import com.boblogservice.member.exception.AlreadyExistMemberException;
import com.boblogservice.member.exception.NotCorrectTwoPasswordException;
import com.boblogservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String NOT_CORRECT_TWO_PASSWORD = "두 개의 비밀번호가 일치하지 않습니다.";
    private static final String NICKNAME_CANNOT_USED = "사용할 수 없는 닉네임입니다.";
    private static final String USERNAME_CANNOT_USED = "사용할 수 없는 아이디입니다.";

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
    public Map<String, String> login(LoginDto loginDto) {
        return null;
    }

    @Override
    public void confirmMemberByNickname(String nickname) {
        Optional<Member> optionalMember = memberRepository.findByNickname(nickname);
        if(optionalMember.isPresent()) {
            throw new AlreadyExistMemberException(NICKNAME_CANNOT_USED);
        }
    }

    @Override
    public void confirmMemberByUsername(String username) {
        Optional<Member> optionalMember = memberRepository.findByUsername(username);
        if(optionalMember.isPresent()) {
            throw new AlreadyExistMemberException(USERNAME_CANNOT_USED);
        }
    }
}
