package com.example.springelasticpratice.service

import com.example.springelasticpratice.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.SearchPage

interface UserService {

    fun saveUser(user: User): User
    fun searchUsersByName(name: String): User?
    fun searchUsersByAge(age: Int, pageable: Pageable) : SearchPage<User>
}
