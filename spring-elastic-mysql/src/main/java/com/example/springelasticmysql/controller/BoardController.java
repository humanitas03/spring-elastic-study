package com.example.springelasticmysql.controller;

import com.example.springelasticmysql.elastic.document.BoardDocument;
import com.example.springelasticmysql.jpa.entity.Board;
import com.example.springelasticmysql.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board/{boardId}")
    public BoardDocument getBoardByIdFromElasticSearch(@PathVariable("boardId") String boardId) {
        return boardService.findBoardByBoardID(boardId);
    }

    @PostMapping("/board")
    public Board createNewBoard(@RequestBody Board board) {
        return boardService.processNewBoard(board);
    }
}
