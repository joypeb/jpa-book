package com.jpa.book.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 50)
    String name;
    @Column(length = 200)
    String address;
}
