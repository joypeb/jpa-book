package com.jpa.book.service;

import com.jpa.book.domain.Author;
import com.jpa.book.domain.Book;
import com.jpa.book.domain.dto.BookResponse;
import com.jpa.book.repository.AuthorRepository;
import com.jpa.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);

        List<BookResponse> bookResponses = books.stream()
                .map(book -> {
                    Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
                    return BookResponse.of(book,optionalAuthor.get().getName());
                }).collect(Collectors.toList());

        return bookResponses;
    }

    public BookResponse findOne(int id) {
        Optional<Book> book = bookRepository.findById(id);

        Optional<Author> author = authorRepository.findById(book.get().getAuthorId());

        return BookResponse.of(book.get(), author.get().getName());
    }
}
