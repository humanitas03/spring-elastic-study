package com.example.springelasticmysql.elastic.document;

import com.example.springelasticmysql.jpa.entity.Board;
import com.example.springelasticmysql.jpa.entity.Comment;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "board")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class BoardDocument {

    @Id // org.springframework.data.annotation.Id
    @Field(type= FieldType.Text)
    private String boardId;

    @Field(type= FieldType.Text)
    private String title;

    @Field(type= FieldType.Text)
    private String author;

    @Field(type= FieldType.Text)
    private String content;

    // TODO : DateFormat.custom deprecated됨에 따라, LocalDateTime 포맷 변환 대안 찾기
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdAt;

    @Field(type = FieldType.Auto)
    private List<Comment> commentList;

    public static BoardDocument fromDomain(Board board) {
        return new BoardDocument(
                board.getBoardId(),
                board.getTitle(),
                board.getAuthor(),
                board.getContent(),
                board.getCreatedAt(),
                board.getCommentList()
        );
    }
}
