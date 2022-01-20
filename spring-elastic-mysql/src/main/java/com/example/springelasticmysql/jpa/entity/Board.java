package com.example.springelasticmysql.jpa.entity;

import com.example.springelasticmysql.jpa.listener.BoardEntityListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@EntityListeners(BoardEntityListener.class)
@Entity
@Table(name = "tb_board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString // not recommend
public class Board {

    @Id // javax.persistence.Id
    @Column(length = 37)
    private String boardId;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> commentList;

    public static Board of(String title, String author, String content) {
        var boardId = UUID.randomUUID();
        return new Board(
                boardId.toString(),
                title,
                author,
                content,
                LocalDateTime.now(),
                new ArrayList<>()
        );
    }


    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

}
