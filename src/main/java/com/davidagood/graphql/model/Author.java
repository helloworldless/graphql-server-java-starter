package com.davidagood.graphql.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Document
public class Author {
    @Id
    private String id;
    private final String firstName;
    private final String lastName;
}
