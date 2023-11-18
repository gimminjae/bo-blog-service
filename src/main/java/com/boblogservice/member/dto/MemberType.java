package com.boblogservice.member.dto;

import lombok.Getter;

@Getter
public enum MemberType {
    KAKAO("K", "KAKAO"),
    NAVER("N", "NAVER"),
    GOOGLE("G", "GOOGLE"),
    COMMON("C", "COMMON");

    private String code;
    private String typeName;

    MemberType(String code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }
}
