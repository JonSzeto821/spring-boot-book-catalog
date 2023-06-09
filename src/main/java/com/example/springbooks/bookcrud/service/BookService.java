package com.example.springbooks.bookcrud.service;

import com.example.springbooks.bookcrud.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void deleteById(int id);
}
