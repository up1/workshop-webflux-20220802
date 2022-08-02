package com.example.demo.webflux;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ListBodySpec;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static reactor.core.publisher.Mono.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = UserController.class)
public class UserControllerSliceTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void case_success_with_getAllUser() {
        List<User2> users = new ArrayList<>();
        users.add(new User2(1, "User 01"));
//        when(userRepository.findAll()).thenReturn(Flux.fromIterable(users));
        ListBodySpec<User2> response = client.get().uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User2.class);

        List<User2> results = response.returnResult().getResponseBody();
        assertEquals(0, results.size());
    }

}