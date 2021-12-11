package com.jboot.domain.member.domain;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "tb_member")
@Entity
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sysid;

    @Column(name = "MEMBER_ID", unique=true)
    String memberId;

    @Column(name = "MEMBER_PW")
    String memberPw;

    String name;

    @Column(name = "AUTH")
    String auth;

    @Column(name = "MEMBER_ROLES")
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public Member() {
    }

    @Builder
    public Member(String member_id, String member_pw, String name) {
        this.memberId = member_id;
        this.memberPw = member_pw;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String member_id) {
        this.memberId = member_id;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String member_pw) {
        this.memberPw = member_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return memberPw;
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    //계정이 만료되었는지 (true: 만료되지 않음)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있는지 (true: 잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //패스워드가 만료되지 않았는지 (true: 만료되지 않음)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화되어 있는지 (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }
}