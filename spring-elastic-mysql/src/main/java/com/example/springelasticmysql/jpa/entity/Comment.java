package com.example.springelasticmysql.jpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(name = "tb_comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Comment {

    @Id @GeneratedValue
    private Long commentId;

    @Column
    private String writer;

    @Column
    private String commentContent;

    @Column
    private LocalDateTime createdAt;

    @Exclude
    @ManyToOne
    private Board board;

    public static Comment of(Board board, String writer, String commentContent) {
        if(board==null)
            throw new RuntimeException("board는 Not Null");

        return new Comment(
                null,
                writer,
                commentContent,
                LocalDateTime.now(),
                board
        );
    }
}
