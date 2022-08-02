package com.example.demo.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ListBodySpec;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebFluxTest(controllers = UserController.class)
public class UserControllerSliceTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void case_success_with_getAllUser() {
        ListBodySpec<User> response = client.get().uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class);

        List<User> users = response.returnResult().getResponseBody();
        assertEquals(2, users.size());
    }

}