package com.spring.mongo.controller;

import com.spring.mongo.model.Book;
import com.spring.mongo.repository.BookRepository;
import com.spring.mongo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private SearchRepository searchRepository;

    @CrossOrigin("http://localhost:3000/")
    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        repository.save(book);
        return "Added book";
    }


    // showing allBooks on /index
    @CrossOrigin
    @GetMapping("/allBooks")
    public List<Book> showBooks() {
        return repository.findAll();
    }

    @GetMapping("index")
    public List<Book> allBooks() {
        return repository.findAll();
    }

    //
    //autocomplete
    @CrossOrigin
    @GetMapping("/showBook/{text}")
    public List<Book> findBooks(@PathVariable String text) {
        return searchRepository.findByText(text);
    }


}