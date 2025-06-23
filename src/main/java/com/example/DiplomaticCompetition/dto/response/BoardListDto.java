package com.example.DiplomaticCompetition.dto.response;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardListDto {
    @Column
    private Long boardId; // 게시판 글 기본키

    @Column
    private String title; //게시판 제목

    @Column
    private  int likeCount; //게시판 좋아요 수

    @Column
    private String nickName; // 작성자  닉넴임
}
