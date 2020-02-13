package com.davidagood.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GraphQLServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraphQLServerApplication.class, args);
    }
}