package com.spring.mongo.repository;

import com.spring.mongo.model.Book;

import java.util.List;

public interface SearchRepository {

    List<Book> findByText(String text);
}
