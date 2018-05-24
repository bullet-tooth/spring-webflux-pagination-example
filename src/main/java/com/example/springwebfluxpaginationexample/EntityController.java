package com.example.springwebfluxpaginationexample;

import static com.example.springwebfluxpaginationexample.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.springwebfluxpaginationexample.PageSupport.FIRST_PAGE_NUM;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class EntityController {

  private final EntityService service;

  @GetMapping("/entities")
  public Mono<PageSupport<Entity>> getEntitiesPage(
      @RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
      @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size
  ) {

    return service.getEntityPage(PageRequest.of(page, size));
  }
}
