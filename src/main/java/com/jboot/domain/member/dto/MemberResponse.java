package com.jboot.domain.member.dto;

import com.jboot.domain.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private String memberId;

    private String name;

    public MemberResponse(final Member member) {
        this.memberId = member.getMember_id();
        this.name = member.getName();
    }
}
