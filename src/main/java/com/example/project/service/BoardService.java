package com.example.project.service;

import com.example.project.board.entity.BoardEntity;
import com.example.project.board.repository.BoardRepository;
import com.example.project.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardDto addBoardServ(final BoardEntity boardEntity){
        boolean flag = boardRepository.addBoard(boardEntity);
        if (!flag){
            log.warn("추가가 잘 되지 않았습니다.");
            throw new RuntimeException("Add Error");
        }
        return showAllServ();
    }

    public BoardDto deleteBoardServ(int num){
        boolean flag = boardRepository.deleteBoard(num);
        if (!flag) {
            log.warn("삭제가 잘 되지 않았습니다.");
            throw new RuntimeException("DELETE FAIL");
        }
        return showAllServ();
    }

    public BoardDto updateBoardServ(BoardEntity boardEntity){
        boardRepository.updateBoard(boardEntity);
        return showAllServ();
    }

    public BoardDto showAllServ(){
        return new BoardDto(boardRepository.showAll());

    }

    public BoardEntity showOneServ(int num){
        BoardEntity boardEntity = boardRepository.showOne(num);
        if (boardEntity == null){
            log.warn("boardentity가 null입니다.");
            throw new RuntimeException("BoardEntity is null");
        }
        return boardEntity;
    }
}
