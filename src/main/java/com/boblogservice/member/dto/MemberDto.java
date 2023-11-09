package com.boblogservice.member.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String memId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private String username;
    private String password;
    private String nickname;
    private String memType;
    private Boolean useYn;
    private String role;
    public static MemberDto from(SignUpDto signUpDto) {
        return MemberDto.builder()
                .username(signUpDto.getUsername())
                .nickname(signUpDto.getNickname())
                .password(signUpDto.getPassword1())
                .memType(signUpDto.getMemType())
                .build();
    }
}
