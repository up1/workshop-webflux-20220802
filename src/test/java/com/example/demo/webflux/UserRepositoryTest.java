package com.example.demo.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import static org.junit.jupiter.api.Assertions.*;


@DataR2dbcTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void case01() {
        // TODO
        userRepository.findByName("name");
    }

}