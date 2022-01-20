package com.example.springelasticmysql.elastic.repository;

import com.example.springelasticmysql.elastic.document.BoardDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardElasticSearchRepository extends ElasticsearchRepository<BoardDocument, String> {

}
