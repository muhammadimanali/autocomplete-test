package com.spring.mongo.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spring.mongo.model.Book;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Book> findByText(String text) {
        final List<Book> book1 = new ArrayList<>();
        MongoDatabase database = client.getDatabase("sample");
        MongoCollection<Document> collection = database.getCollection("book");
        AggregateIterable<Document> result = collection.aggregate(
                Arrays.asList(new Document("$search",
                new Document("index", "default")
                .append("autocomplete",
                new Document("query", text)
                .append("path", "title")
                .append("tokenOrder", "sequential")
                .append("fuzzy", new Document("maxEdits", 1L)))),
                new Document("$sort",
                new Document("year", 1L)),
                new Document("$limit", 3L)));

        result.forEach(doc -> book1.add(converter.read(Book.class,doc)));

        return book1;
    }
}