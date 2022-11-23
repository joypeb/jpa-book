package com.jpa.book.domain.dto;

import com.jpa.book.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private int bookId;
    private String bookName;
    private String autohorName;

    public static BookResponse of(Book book, String autohorName) {
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .autohorName(autohorName)
                .build();
    }
}
