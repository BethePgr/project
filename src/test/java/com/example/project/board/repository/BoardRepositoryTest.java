package com.example.project.board.repository;

import com.example.project.board.entity.BoardEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired BoardRepository boardRepository;

    @Test
    @DisplayName("addboardtest true떠여함")
    void addBoardTest(){
        //given
        BoardEntity boardEntity = new BoardEntity("제목123","사진00","내용00","닉네임00");
        //when
        boolean flag = boardRepository.addBoard(boardEntity);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("3개가 되어야함")
    void deleteBoardTest(){
        //given
        int num = 5;
        //when
        boolean flag = boardRepository.deleteBoard(num);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("id가 주어질 때 이미지랑 내용만 update해버리기")
    void updateBoardTest(){
        //given
        BoardEntity boardEntity = new BoardEntity(6,"제목","이미지","내용","닉네임");
        //then
        boolean flag = boardRepository.updateBoard(boardEntity);
        //when
        assertTrue(flag);
    }

    @Test
    @DisplayName("번호가 들어올때 그 번호에 해당되는 게시판만 보여주기")
    void showOneTest(){
        //given
        int num = 1;
        //when
        BoardEntity boardEntity = boardRepository.showOne(1);
        //then
        System.out.println(boardEntity);
        assertNotNull(boardEntity);
    }

    @Test
    @DisplayName("게시판의 모든 내용들을 알려주기")
    void showAllTest(){
        //given
        //when
        List<BoardEntity> boardEntities = boardRepository.showAll();
        //then
        assertEquals(3,boardEntities.size());
        assertNotNull(boardEntities);
        System.out.println(boardEntities);
    }


}