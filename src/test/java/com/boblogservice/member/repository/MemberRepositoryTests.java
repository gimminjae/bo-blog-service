package com.boblogservice.member.repository;

import com.boblogservice.member.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;


@DataJpaTest
@Sql("/sql/member-repository-test.sql")
@TestPropertySource("classpath:test-application.yml")
public class MemberRepositoryTests {
    private final String alreadyMemId = "20231104Me3cf1f7b-a715-4a8b-864a-b69826498c58";
    private final String alreadyNickname = "testuser";
    private final String alreadyUsername = "testuser";

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 생성")
    void save() {
        //given

        //when

        //then
    }
    @Test
    @DisplayName("회원 조회 by memId")
    void findById() {

    }
    @Test
    @DisplayName("회원 조회 by username")
    void findByUsername() {

    }
    @Test
    @DisplayName("회원 조회 by nickname")
    void findByNickname() {

    }
    @Test
    @DisplayName("회원 수정")
    void saveUpdate() {

    }
    @Test
    @DisplayName("회원 삭제")
    void delete() {

    }
}
