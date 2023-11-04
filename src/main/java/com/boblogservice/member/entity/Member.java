package com.boblogservice.member.entity;

import com.boblogservice.member.dto.MemberDto;
import com.boblogservice.member.dto.MemberType;
import com.boblogservice.member.dto.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

import static com.boblogservice.common.generator.IdGenerator.ENTITY_TYPE;

@Entity
@Getter
@Table(name = "member")
public class Member {
    @Id
    @Column(columnDefinition = "varchar(255)", name = "memId")
    @GenericGenerator(
            name = "memId",
            strategy = "com.boblogservice.common.generator.IdGenerator",
            parameters = {
                    @Parameter(name = ENTITY_TYPE, value = "M"),
            }
    )
    @GeneratedValue(generator = "memId")
    private String memId;

    @Column(name = "createDateTime", nullable = false)
    private LocalDateTime createDateTime;

    @Column(name = "updateDateTime", nullable = false)
    private LocalDateTime updateDateTime;

    @Column(columnDefinition = "varchar(50)", name = "username", nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(50)", name = "password")
    private String password;

    @Column(columnDefinition = "varchar(50)", name = "nickname", nullable = false)
    private String nickname;

    @Column(columnDefinition = "char(1)", name = "memType", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MemberType memType;

    @Column(columnDefinition = "boolean", name = "useYn", nullable = false)
    private Boolean useYn;

    @Column(columnDefinition = "varchar(10)", name = "role", nullable = false)
    @ColumnDefault("1")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Builder
    private Member(String username,
                   String password,
                   String nickname,
                   MemberType memType) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.memType = memType;
    }

    public static Member from(MemberDto memberDto) {
        return Member.builder()
                .username(memberDto.getUsername())
                .nickname(memberDto.getNickname())
                .password(memberDto.getPassword())
                .memType(MemberType.valueOf(memberDto.getMemType()))
                .build();
    }
}
