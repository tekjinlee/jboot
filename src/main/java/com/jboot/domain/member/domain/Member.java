package com.jboot.domain.member.domain;

import lombok.Builder;

import javax.persistence.*;

@Table(name = "tb_member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sysid;
    String member_id;
    String member_pw;
    String name;

    public Member() {
    }

    @Builder
    public Member(String member_id, String member_pw, String name) {
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.name = name;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}