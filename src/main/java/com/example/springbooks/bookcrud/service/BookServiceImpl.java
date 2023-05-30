package com.example.springbooks.bookcrud.service;

import com.example.springbooks.bookcrud.dao.BookDAO;
import com.example.springbooks.bookcrud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO theBookDAO) {
        bookDAO = theBookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Transactional
    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }
}
