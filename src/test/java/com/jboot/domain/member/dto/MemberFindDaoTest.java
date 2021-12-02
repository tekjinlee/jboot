package com.jboot.domain.member.dto;

import com.jboot.domain.member.dao.MemberFindDao;
import com.jboot.domain.member.dao.MemberRepository;
import com.jboot.domain.member.domain.Member;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberFindDaoTest {

    @Autowired
    MemberFindDao memberFindDao;

    @Mock
    private MemberRepository memberRepository;

    @Test
    public void findMemberByMemberId(){
        final Member member = memberFindDao.findByMemberId("test");
        Assertions.assertEquals(member.getMemberId(), "test");
    }
}
