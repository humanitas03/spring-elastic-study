package com.example.springelasticpratice.service

import com.example.springelasticpratice.entity.User
import com.example.springelasticpratice.repository.UserElasticSearchRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.SearchPage
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl constructor(
    val userElasticSearchRepository: UserElasticSearchRepository
) : UserService {

    override fun saveUser(user: User): User {
        return userElasticSearchRepository.save(user)
    }

    override fun searchUsersByName(name: String): User? {
        return userElasticSearchRepository.findByName(name)
    }

    override fun searchUsersByAge(age: Int, pageable: Pageable): SearchPage<User> {
        return userElasticSearchRepository.findAllByAge(age, pageable)
    }
}
