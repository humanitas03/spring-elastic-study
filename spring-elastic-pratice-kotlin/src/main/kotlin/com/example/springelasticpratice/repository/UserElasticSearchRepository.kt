package com.example.springelasticpratice.repository

import com.example.springelasticpratice.entity.User
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.SearchPage
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface UserElasticSearchRepository : ElasticsearchRepository<User, Long> {
    fun findByName(name: String): User?
    fun findAllByAge(age: Int, page: Pageable): SearchPage<User>
}
