package com.example.springelasticmysql.jpa.repository;

import com.example.springelasticmysql.jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {

}
