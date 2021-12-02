package com.jboot.domain.member.application;

import com.jboot.domain.member.dao.MemberRepository;
import com.jboot.domain.member.domain.Member;
import com.jboot.domain.member.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {
    private final MemberRepository memberRepository;

    public Member doSighUp(final SignUpRequest dto){

        return memberRepository.save(dto.toEntity());
    }
}
