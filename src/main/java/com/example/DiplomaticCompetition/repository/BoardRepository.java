package com.example.DiplomaticCompetition.repository;

import com.example.DiplomaticCompetition.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query(value = "SELECT b FROM Board b ")
    List<Board> findBoardWithOffset(@Param("offset") int offset, org.springframework.data.domain.Pageable pageable);

    Optional<Board> findById(Long id);
}
