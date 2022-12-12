package com.example.project.dto;

import com.example.project.board.entity.BoardEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int count;
    private List<BoardEntity>boardEntityList;

    public BoardDto(List<BoardEntity> boardEntityList){
        this.count = boardEntityList.size();
        this.boardEntityList = boardEntityList;
    }

    public List<BoardEntity> convertList(List<BoardEntity> boardEntityList){
        List<BoardEntity> boards = new ArrayList<>();
        for(BoardEntity b : boardEntityList){
            boards.add(b);
        }
        return boards;
    }
}
