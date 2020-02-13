package com.davidagood.graphql.resolver;

import com.davidagood.graphql.model.Author;
import com.davidagood.graphql.model.Book;
import com.davidagood.graphql.repository.AuthorRepository;
import com.davidagood.graphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Resolvers {

    public DataFetcher<Book> queryBook(BookRepository bookRepository) {
        return env -> {
            String bookId = env.getArgument("id");
            return bookRepository.findById(bookId)
                    .orElseThrow(() -> new RuntimeException("Failed to find book with id=" + bookId));
        };
    }

    public DataFetcher<Author> queryAuthor(AuthorRepository authorRepository) {
        return env -> {
            String authorId = env.getArgument("id");
            return authorRepository.findById(authorId)
                    .orElseThrow(() -> new RuntimeException("Failed to find author with id=" + authorId));
        };
    }

    public DataFetcher<Author> getAuthorForBook(AuthorRepository authorRepository) {
        return env -> {
            Book book = env.getSource();
            String authorId = book.getAuthor().getId();
            return authorRepository.findById(authorId)
                    .orElseThrow(() -> new RuntimeException("Failed to find author with id=" + authorId));

        };
    }

}
