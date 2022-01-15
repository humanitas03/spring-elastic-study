package com.example.springelasticpratice.configuration

import com.example.springelasticpratice.entity.User
import com.example.springelasticpratice.repository.UserElasticSearchRepository
import com.github.javafaker.Faker
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.util.stream.Stream
import kotlin.random.Random

@Component
@Transactional
class ResetUsersRunner constructor(
    val userElasticSearchRepository: UserElasticSearchRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        userElasticSearchRepository.deleteAll()
        val faker = Faker()
        Flux.fromStream {
            Stream
                .generate {
                    User(
                        id = null,
                        name = faker.name().firstName(),
                        age = Random.nextInt(0, 30)
                    )
                }
        }
            .take(1_000)
            .parallel(20)
            .runOn(Schedulers.newParallel("Parallel", 20))
            .doOnNext {
                userElasticSearchRepository.save(it)
            }
            .subscribe()
    }
}
