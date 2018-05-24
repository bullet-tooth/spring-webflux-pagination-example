package com.example.springwebfluxpaginationexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityControllerTest {

  @Autowired
  private ApplicationContext context;
  private WebTestClient client;

  @Before
  public void setUp() {
    client = WebTestClient.bindToApplicationContext(context).build();
  }

  @Test
  public void defaultPaginationTest() {
    client.get()
        .uri("/entities")
        .exchange()
        .expectBody()
        .jsonPath("$.content").isArray()
        .jsonPath("$.content.length()").isEqualTo(7)
        .jsonPath("pageNumber").isEqualTo(0)
        .jsonPath("pageSize").isEqualTo(20)
        .jsonPath("totalElements").isEqualTo(7)
        .jsonPath("first").isEqualTo(true)
        .jsonPath("last").isEqualTo(true)
        .jsonPath("totalPages").isEqualTo(1);
  }

  @Test
  public void requestedPaginationTest() {
    client.get()
        .uri(uriBuilder ->
            uriBuilder.path("/entities")
                .queryParam("page", 1)
                .queryParam("size", 2)
                .build())
        .exchange()
        .expectBody()
        .jsonPath("$.content").isArray()
        .jsonPath("$.content.length()").isEqualTo(2)
        .jsonPath("pageNumber").isEqualTo(1)
        .jsonPath("pageSize").isEqualTo(2)
        .jsonPath("totalElements").isEqualTo(7)
        .jsonPath("first").isEqualTo(false)
        .jsonPath("last").isEqualTo(false)
        .jsonPath("totalPages").isEqualTo(4);
  }

}
