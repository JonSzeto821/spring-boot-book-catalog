package com.example.springbooks.bookcrud.service;

import com.example.springbooks.bookcrud.entity.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    Book save(Book book);

    void deleteById(int id);
}
