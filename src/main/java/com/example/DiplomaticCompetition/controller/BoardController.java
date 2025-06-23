package com.example.DiplomaticCompetition.controller;


import com.example.DiplomaticCompetition.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping(value="board-list")
    public ResponseEntity<?> getBoardList( @RequestParam(name = "pageNumber",defaultValue = "1") int pageNumber) {
        return new ResponseEntity<>(boardService.getBoardList(pageNumber), HttpStatus.OK);
    }
    @GetMapping(value = "/board-detail") //상세 페이지
    public ResponseEntity<?> getBookDetailInfo( @RequestParam("boardId") Long boardId) { //
        return new ResponseEntity<>(boardService.getBookDetailInfo(boardId), HttpStatus.OK);
    }
}
