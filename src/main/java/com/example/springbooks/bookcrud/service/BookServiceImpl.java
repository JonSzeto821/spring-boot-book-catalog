package com.example.springbooks.bookcrud.service;

import com.example.springbooks.bookcrud.dao.BookRepository;
import com.example.springbooks.bookcrud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> result = bookRepository.findById(id);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }

        return theBook;
    }

    @Transactional
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
