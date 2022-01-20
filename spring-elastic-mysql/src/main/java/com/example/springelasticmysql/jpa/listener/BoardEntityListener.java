package com.example.springelasticmysql.jpa.listener;

import com.example.springelasticmysql.elastic.document.BoardDocument;
import com.example.springelasticmysql.elastic.repository.BoardElasticSearchRepository;
import com.example.springelasticmysql.jpa.entity.Board;
import javax.persistence.PostPersist;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardEntityListener {

    @Autowired
    private BoardElasticSearchRepository boardElasticSearchRepository;

    @PostPersist
    public void addElasticNewBoard(Board board) {
        if(boardElasticSearchRepository == null) {
            System.out.println("skip save new Board in Elastic Search ");
            return;
        }
        System.out.println("Save new Board in Elastic Search ");
        boardElasticSearchRepository.save(BoardDocument.fromDomain(board));
    }
}
