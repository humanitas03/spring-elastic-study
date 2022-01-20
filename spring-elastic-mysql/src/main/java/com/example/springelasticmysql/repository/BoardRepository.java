package com.example.springelasticmysql.repository;

import com.example.springelasticmysql.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
