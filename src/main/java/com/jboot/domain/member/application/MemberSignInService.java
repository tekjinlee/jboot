package com.jboot.domain.member.application;

import com.jboot.common.jwt.JwtAuthenticationProvider;
import com.jboot.domain.member.dto.MemberResponseDto;
import com.jboot.domain.member.dto.Response;
import com.jboot.domain.member.dto.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignInService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final Response response;

    public ResponseEntity<?> login(SignInRequest signIn){
        // Login ID/PW 기반으로 Authentication 객체 생성
        // 이때 authentication는 인증 여부를 확인하는 authenticated 값이 fasle
        UsernamePasswordAuthenticationToken authenticationToken = signIn.toAuthentication();

        // 실제 검증
        // authenticate 매서드가 실행될 때 CustomUserDetailService 에서 만든 loadUserByUsername 메서드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // JWT 토큰 생성
        MemberResponseDto.TokenInfo tokenInfo = jwtAuthenticationProvider.generateToken(authentication);

        // TODO: 2021-12-11 Redis ..
        return response.success(tokenInfo, "로그인 성공", HttpStatus.OK);
    }
}
