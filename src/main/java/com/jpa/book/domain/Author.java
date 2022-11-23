package com.jpa.book.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 45)
    String name;
}
