package com.example.DiplomaticCompetition.service;


import com.example.DiplomaticCompetition.domain.Board;
import com.example.DiplomaticCompetition.dto.response.BoardListDto;
import com.example.DiplomaticCompetition.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public List<BoardListDto>getBoardList(int offset){
        PageRequest pageRequest = PageRequest.of(offset-1, 10); // offset부터 10개
        List<BoardListDto> boardListDtos = new ArrayList<>();
        List<Board>  boarList = boardRepository.findBoardWithOffset(offset, pageRequest);
        for (Board board : boarList){
            BoardListDto boardListDto = BoardListDto.builder()
                    .boardId(board.getId()).
                    nickName(board.getNickName()).
                    likeCount(board.getLikeCount()).
                    title(board.getTitle()).
                    build();
            boardListDtos.add(boardListDto);
        }
        return boardListDtos;
    }

}
