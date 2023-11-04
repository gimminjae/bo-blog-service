package com.boblogservice.member.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;


@DataJpaTest
@Sql("/sql/member-repository-test.sql")
@TestPropertySource("classpath:test-application.yml")
public class MemberRepositoryTests {
    @Test
    @DisplayName("회원 생성")
    void save() {

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
