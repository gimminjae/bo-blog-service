package com.boblogservice.member.dto;

import lombok.Getter;

@Getter
public enum MemberType {
    KAKAO('K', "kakao"),
    NAVER('N', "naver"),
    GOOGLE('G', "google"),
    COMMON('C', "common");

    private Character code;
    private String typeName;

    MemberType(Character code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }
}
