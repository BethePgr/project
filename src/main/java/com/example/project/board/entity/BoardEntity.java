package com.example.project.board.entity;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    private int num;
    private String title;
    private String image;
    private String contents;
    private String nickname;

    public BoardEntity(String title, String image, String contents, String nickname) {
        this.title = title;
        this.image = image;
        this.contents = contents;
        this.nickname = nickname;
    }
}