package com.jboot.domain.member.dao;

import com.jboot.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberFindDao {
    private final MemberRepository memberRepository;

    public Member findByMemberId(final String memberId){
        final Optional<Member> member = memberRepository.findByMemberId(memberId);
        member.orElseThrow(()-> new EntityNotFoundException(memberId));
        return member.get();
    }
}
