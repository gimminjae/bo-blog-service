package com.boblogservice.member.dto;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    @NotNull(message = "아이디는 필수항목입니다.")
    @Size(min = 5, max = 16, message = "아이디는 5 ~16자 이어야 합니다.")
    private String username;
    @NotNull(message = "닉네임은 필수항목입니다.")
    @Size(min = 5, max = 16, message = "닉네임은 5 ~16자 이어야 합니다.")
    private String nickname;
    @NotNull(message = "비밀번호는 필수항목입니다.")
    @Size(min = 5, max = 16, message = "비밀번호는 5 ~16자 이어야 합니다.")
    private String password1;
    @NotNull(message = "비밀번호 확인은 필수항목입니다.")
    @Size(min = 5, max = 16, message = "비밀번호 확인은 5 ~16자 이어야 합니다.")
    private String password2;
    private String memType;
}
