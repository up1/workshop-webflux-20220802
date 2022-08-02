package com.example.demo.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public Flux<User> getAll() {
        return Flux.just(new User(), new User());
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable int id) {
        return Mono.just(new User());
    }

}
