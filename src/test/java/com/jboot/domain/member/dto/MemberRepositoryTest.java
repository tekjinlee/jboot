package com.jboot.domain.member.dto;

import com.jboot.domain.member.dao.MemberRepository;
import com.jboot.domain.member.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void name() throws Exception {
       assertEquals("hello","hello");
    }

    @Test
    public void save() throws Exception {
        Member member = new Member("test","test","test");
        memberRepository.save(member);
    }
}