package com.jboot.domain.member.dto;

import com.jboot.domain.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;


@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest {

    @Valid
    private String memberId;

    @Valid
    private String memberPw;

    @Valid
    private String name;

    public SignUpRequest(@Valid String memberId, @Valid String memberPw, @Valid String name) {
        // TODO: 2021-07-02 member Pw 에 대한 해쉬 및 암호화에 대해 추가 할 것 
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
    }

    public Member toEntity(){
        return Member.builder()
                .member_id(memberId)
                .member_pw(memberPw)
                .name(name)
                .build();
    }
}
