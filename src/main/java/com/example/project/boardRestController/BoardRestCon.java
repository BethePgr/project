package com.example.project.boardRestController;

import com.example.project.board.entity.BoardEntity;
import com.example.project.dto.BoardDto;
import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/project/board")
@RequiredArgsConstructor
public class BoardRestCon {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody BoardEntity boardEntity){
        log.info("POSTMAPPING add request");
        try {
            BoardDto boardDto = boardService.addBoardServ(boardEntity);
            return ResponseEntity.ok().body(boardDto);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> showAll(){
        log.info("GetMapping showAll Request");
        return ResponseEntity.ok().body(boardService.showAllServ());
    }

    @GetMapping("/{num}")
    public ResponseEntity<?> showOne(@PathVariable int num){
        log.info("GetMapping showOne Request");
        try {
            BoardEntity boardEntity = boardService.showOneServ(num);
            if (boardEntity == null) ResponseEntity.badRequest().build();
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(boardService.showOneServ(num));
    }

    @PutMapping
    public ResponseEntity<?> updateBoard(@RequestBody BoardEntity boardEntity){
        log.info("PUTMapping updateBoard Request");
        BoardDto boardDto = boardService.updateBoardServ(boardEntity);
        return ResponseEntity.ok().body(boardDto);
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<?> deleteBoard(@PathVariable  int num){
        log.info("DELETEMapping deleteBoard Request");
        try {
            BoardDto boardDto = boardService.deleteBoardServ(num);
            if (boardDto == null) ResponseEntity.badRequest().build();
            return ResponseEntity.ok().body(boardDto);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
