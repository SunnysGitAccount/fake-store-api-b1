package com.dev.sunny.bootstrap;

import com.dev.sunny.model.Book;
import com.dev.sunny.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BoostrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book b1, b2;
        b1 = Book.builder()
                .title("The Alchemist")
                .isbn("9780062315007")
                .authorName("Paulo Coelho")
                .build();
        b2 = Book.builder()
                .title("The Da Vinci Code")
                .isbn("9780307474278")
                .authorName("Dan Brown")
                .build();

        persistingBooks(b1, b2);

//        TODO: Persist Author to repository

//        TODO: Persist Publisher to repository
    }

    private void persistingBooks(Book b1, Book b2) throws Exception {
        try {
            bookRepository.save(b1);
            bookRepository.save(b2);
        } catch (IllegalArgumentException e) {
            throw new Exception(e);
        }

        System.out.println("Books saved: " + bookRepository.count());
        bookRepository.findAll()
                .forEach(System.out::println);

        Optional<Book> savedBook = bookRepository.findById(1L);
        savedBook.ifPresent(System.out::println);
    }
}
