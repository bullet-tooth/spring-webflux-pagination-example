# Spring Webflux pagination example
By default **spring-webflux** does't support pagination because `Flux` designed to be unbounded.
This project shows custom implementation of pagination for reactive stack.

* `com.example.springwebfluxpaginationexample.EntityController` describes request mapping for pageable requests
* `com.example.springwebfluxpaginationexample.EntityService` describes Flux to Page mapping.

## Request & Response examples:
Request:
`GET http://localhost:8080/entities`  

Response:
``` json
{
  "content": [
    {
      "name": "Ukraine"
    },
    {
      "name": "Spain"
    },
    {
      "name": "Canada"
    },
    {
      "name": "China"
    },
    {
      "name": "Croatia"
    },
    {
      "name": "Italy"
    },
    {
      "name": "Egypt"
    }
  ],
  "pageNumber": 0,
  "pageSize": 20,
  "totalElements": 7,
  "first": true,
  "last": true,
  "totalPages": 1
}
``` 
Request:
`GET http://localhost:8080/entities?page=0&size=2`  

Response:
``` json
{
  "content": [
    {
      "name": "Ukraine"
    },
    {
      "name": "Spain"
    }
  ],
  "pageNumber": 0,
  "pageSize": 2,
  "totalElements": 7,
  "first": true,
  "last": false,
  "totalPages": 4
}

``` 

## Technology stack
* Maven
* Spring boot 2.0
* Spring webflux
* Lombok


## Pay attention:
**This solution is not optimized at performance perspective.** 
Each time we fetch all entities form repository (database) and then map them to the requested page. 

