package com.example.DiplomaticCompetition.dto.response;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailDto {
    @Column
    private String title; //게시판 제목

    @Column
    private  int likeCount; //게시판 좋아요 수

    @Column
    private String nickName; // 작성자  닉넴임

    @Column
    private String content; // 본문내용
}
