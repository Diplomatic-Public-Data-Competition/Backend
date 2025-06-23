package com.example.DiplomaticCompetition.repository;

import com.example.DiplomaticCompetition.domain.Board;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {
    @Query(value = "SELECT b FROM board b ")
    List<Board> findBoardWithOffset(@Param("offset") int offset, org.springframework.data.domain.Pageable pageable);
}
