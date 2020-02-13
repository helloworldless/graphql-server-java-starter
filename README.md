# GraphQL Server Java

## Running Locally
1. Expects `mongod` to be running @ `localhost:27017`
1. Data will be seeded into `book` and `author` collections when the app starts up
1. Run `com.davidagood.graphql.GraphQLServerApplication` or manually run `./gradlew bootRun`
1. Starts @ [http://localhost:8080](http://localhost:8080)
1. Run a query by checking an id logged at start-up, filling it into 
one of the queries below, and requesting `POST http://localhost:8080/graphql` with the 
query in the request body 
1. Alternatively, use a GraphQL client or GraphQL Playground to send the query


```graphql
{
    book(id: "<BOOK_ID_HERE>") {
        id
        name
        pageCount
        author {
            firstName
            lastName
        }
    }
}
```

```graphql
{
    author(id: "<AUTHOR_ID_HERE>") {
        id
        firstName
        lastName
    }
}
```
