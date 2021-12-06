package com.jboot.domain.member.application;

import com.jboot.domain.member.dao.MemberRepository;
import com.jboot.domain.member.domain.Member;
import com.jboot.domain.member.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {
    private final MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member doSighUp(final SignUpRequest dto){
        dto.passwordEncoding(passwordEncoder.encode(dto.getMemberPw()));
        return memberRepository.save(dto.toEntity());
    }
}
