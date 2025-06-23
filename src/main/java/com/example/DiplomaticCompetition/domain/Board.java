package com.example.DiplomaticCompetition.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    @Column
    private String title; // 제목

    @Column
    private String content; // 본문

    @Column
    private String nickName; //  닉네임

    @Column // 게시글 좋아요 수
    private int likeCount;


    public void onLikeCnt() {//좋아요 수 증가
        this.likeCount += 1;
    }

    public void updateBoard(String title, String content) { //게시글 수정
        this.title = title;
        this.content = content;

    }

}
