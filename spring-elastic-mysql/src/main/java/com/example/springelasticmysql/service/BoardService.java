package com.example.springelasticmysql.service;

import com.example.springelasticmysql.elastic.document.BoardDocument;
import com.example.springelasticmysql.jpa.entity.Board;
import com.example.springelasticmysql.elastic.repository.BoardElasticSearchRepository;
import com.example.springelasticmysql.jpa.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class BoardService {

    @Autowired
    BoardElasticSearchRepository boardElasticSearchRepository;

    @Autowired
    BoardRepository boardRepository;

    public Board processNewBoard(Board board) {
        return boardRepository.save(Board.of(board.getTitle(), board.getAuthor(), board.getContent()));
    }

    public BoardDocument findBoardByBoardID(String boardId) {
        BoardDocument findDocument = boardElasticSearchRepository.findById(boardId).get();
        log.info("find from Es  : " + findDocument);
        return findDocument;
    }
}
