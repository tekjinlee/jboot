package com.jboot.domain.member.dto;

import com.jboot.domain.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.Valid;


@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignInRequest {

    @Valid
    private String memberId;

    @Valid
    private String memberPw;

    public SignInRequest(@Valid String memberId, @Valid String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }

    public Member toEntity(){
        return Member.builder()
                .member_id(memberId)
                .member_pw(memberPw)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(memberId, memberPw);
    }

//    public void passwordEncoding(String encodingPassword){
//        this.memberPw = encodingPassword;
//    }
}
