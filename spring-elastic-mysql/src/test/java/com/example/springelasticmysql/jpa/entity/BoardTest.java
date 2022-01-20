package com.example.springelasticmysql.jpa.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.springelasticmysql.jpa.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("Board cascade 테스트")
    @Transactional
    public void boardCascadeTest() {
        var board = Board.of("제목", "작성자", "콘텐츠");
        var savedBoard = boardRepository.save(board);
        var testComment = Comment.of(savedBoard, "댓글러", "댓글");
        savedBoard.addComment(testComment);
        boardRepository.save(savedBoard);

        var savedResult = boardRepository.findById(savedBoard.getBoardId());
        System.out.println(savedResult);
        assertNotNull(savedResult.get().getCommentList().get(0));
    }
}
