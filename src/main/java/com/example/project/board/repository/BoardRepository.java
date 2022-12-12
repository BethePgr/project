package com.example.project.board.repository;

import com.example.project.board.entity.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    //게시판 생성하기
    boolean addBoard(BoardEntity boardEntity);
    //게시판 삭제하기
    boolean deleteBoard(int seq);
    //게시판 수정하기
    boolean updateBoard(BoardEntity boardEntity);
    //게시판 모두 보여주기
    List<BoardEntity> showAll();
    //게시판 하나만 보여주기
    BoardEntity showOne(int seq);
}