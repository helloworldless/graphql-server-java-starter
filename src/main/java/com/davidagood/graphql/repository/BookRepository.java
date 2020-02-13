package com.davidagood.graphql.repository;

import com.davidagood.graphql.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}