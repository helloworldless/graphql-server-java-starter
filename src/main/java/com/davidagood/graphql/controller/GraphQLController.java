package com.davidagood.graphql.controller;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GraphQLController {

    private final GraphQL graphQL;

    @GetMapping(value = "/graphql")
    public Map<String, Object> graphql(@RequestParam String query) {
        return executeQuery(query);
    }

    @PostMapping(value = "/graphql")
    public Map<String, Object> graphqlPost(@RequestBody String query) {
        return executeQuery(query);
    }

    private Map<String, Object> executeQuery(@RequestBody String query) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().query(query).build();
        ExecutionResult executionResult = this.graphQL.execute(executionInput);
        return executionResult.toSpecification();
    }

}
