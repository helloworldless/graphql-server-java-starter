package com.davidagood.graphql.repository;

import com.davidagood.graphql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}