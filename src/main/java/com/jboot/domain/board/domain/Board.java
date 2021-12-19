package com.jboot.domain.board.domain;

import com.jboot.common.domain.BaseTimeEntity;
import com.jboot.domain.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_BOARD")
public class Board extends BaseTimeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @ManyToOne
    private Member member;

    @Builder
    public Board(Long id, String title, String subTitle, String content, Member member){
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.member = member;
    }

    public void update(Board board){
        this.title = board.getTitle();
        this.subTitle = board.getSubTitle();
        this.content = board.getContent();
    }

}
