package com.example.springwebfluxpaginationexample;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ReactiveEntityRepository {

  public Flux<Entity> findAll() {
    return Flux.just(
        new Entity("Ukraine"),
        new Entity("Spain"),
        new Entity("Canada"),
        new Entity("China"),
        new Entity("Croatia"),
        new Entity("Italy"),
        new Entity("Egypt")
    );
  }
}
