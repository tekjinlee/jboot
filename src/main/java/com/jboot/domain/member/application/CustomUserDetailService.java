package com.jboot.domain.member.application;

import com.jboot.domain.member.dao.MemberFindDao;
import com.jboot.domain.member.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberFindDao memberFindDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberFindDao.findByMemberId(username);
                //.orElseThrow(() -> new UsernameNotFoundException("Not Found User.") );
    }
}
