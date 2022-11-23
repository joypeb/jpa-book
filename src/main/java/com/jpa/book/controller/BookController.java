package com.jpa.book.controller;

import com.jpa.book.domain.Book;
import com.jpa.book.domain.dto.BookResponse;
import com.jpa.book.repository.BookRepository;
import com.jpa.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable) {
         return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> findOne(@PathVariable int id) {
        return ResponseEntity.ok().body(bookService.findOne(id));
    }
}
