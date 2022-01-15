package com.example.springelasticpratice.controller

import com.example.springelasticpratice.entity.User
import com.example.springelasticpratice.service.UserService
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.SearchPage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController constructor(
    val userService: UserService
) {

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }

    @GetMapping("/user/{name}")
    fun findUserByName(
        @PathVariable("name") name: String
    ): User? {
        return userService.searchUsersByName(name)
    }

    @GetMapping("/users/{age}")
    fun findUserByAge(
        @PathVariable("age") age: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): SearchPage<User> {
        return userService.searchUsersByAge(age, Pageable.ofSize(size).withPage(0))
    }
}
