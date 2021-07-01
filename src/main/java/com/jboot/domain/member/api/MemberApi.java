package com.jboot.domain.member.api;

import com.jboot.domain.member.application.MemberSignUpService;
import com.jboot.domain.member.domain.Member;
import com.jboot.domain.member.dto.MemberResponse;
import com.jboot.domain.member.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberApi {
    // TODO: 2021-07-02 일반 등록만 신규 생성 조회 및 email 등 형식에 대한 Validation
    private final MemberSignUpService memberSignUpService;

    @PostMapping
    public MemberResponse create(@RequestBody @Valid final SignUpRequest dto) {
        final Member member = memberSignUpService.doSighUp(dto);
        return new MemberResponse(member);
    }
}
