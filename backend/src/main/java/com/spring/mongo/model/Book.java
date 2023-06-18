package com.spring.mongo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "book")
public class Book {

    private String title;
    private String author;
    private int year;
    private String genre;

}
