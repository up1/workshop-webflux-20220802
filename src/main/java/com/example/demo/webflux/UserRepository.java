package com.example.demo.webflux;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository
        extends ReactiveCrudRepository<User2, Integer> {

    @Query("SELECT * FROM user2 where name = :name")
    Flux<User2> findByName(String name);

}
