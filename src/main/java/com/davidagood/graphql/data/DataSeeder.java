package com.davidagood.graphql.data;

import com.davidagood.graphql.model.Author;
import com.davidagood.graphql.model.Book;
import com.davidagood.graphql.repository.AuthorRepository;
import com.davidagood.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) {
        authorRepository.deleteAll();
        bookRepository.deleteAll();

        Author rowling = new Author("J", "Rowling");
        Author melville = new Author("H", "Melville");
        Author rice = new Author("A", "Rice");
        List<Author> authors = List.of(rowling, melville, rice);
        authorRepository.saveAll(authors);
        log.info("Added authors: {}", authors);

        Book potter = new Book("Harry Potter", 223, rowling);
        Book moby = new Book("Moby Dick", 635, melville);
        Book vampire = new Book("Vampire", 371, rice);

        List<Book> books = List.of(potter, moby, vampire);
        bookRepository.saveAll(books);
        log.info("Added books: {}", books);


    }
}
