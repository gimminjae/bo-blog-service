package com.boblogservice.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
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
}
