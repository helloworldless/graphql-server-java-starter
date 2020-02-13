package com.davidagood.graphql.model;

import com.davidagood.graphql.model.Author;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class Book {
    @Id
    private String id;
    private final String name;
    private final int pageCount;
    @DBRef
    private final Author author;
}
