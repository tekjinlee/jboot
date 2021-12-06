package com.jboot.domain.member.api;

import com.jboot.domain.member.application.MemberSignUpService;
import com.jboot.domain.member.dao.MemberFindDao;
import com.jboot.domain.member.domain.Member;
import com.jboot.domain.member.dto.MemberResponse;
import com.jboot.domain.member.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberApi {
    // TODO: 2021-07-02 일반 등록만 신규 생성 조회 및 email 등 형식에 대한 Validation
    private final MemberSignUpService memberSignUpService;
    private final MemberFindDao memberFindDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public MemberResponse create(@RequestBody @Valid final SignUpRequest dto) {
        // FindId 중복체크 후 처리

        final Member member = memberSignUpService.doSighUp(dto);
        return new MemberResponse(member);
    }

    @GetMapping("/{memberId}")
    public MemberResponse findMember(@PathVariable String memberId){
        return new MemberResponse(memberFindDao.findByMemberId(memberId));
    }
}
