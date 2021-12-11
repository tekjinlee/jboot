package com.jboot.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MemberResponseDto {

    @Builder
    @Getter
    @AllArgsConstructor
    public static class TokenInfo{
        private String grantType;
        private String accessToekn;
        private String refreshToken;
        private Long refreshTokenExpirationTime;
    }
}
