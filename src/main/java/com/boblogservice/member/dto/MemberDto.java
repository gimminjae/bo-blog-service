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

}
