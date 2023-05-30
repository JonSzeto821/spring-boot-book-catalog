package com.example.springbooks.bookcrud.rest;

import com.example.springbooks.bookcrud.entity.Book;
import com.example.springbooks.bookcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book findById(@PathVariable int bookId) {
        Book book = bookService.findById(bookId);

        //TODO create error handler to catch non-int parameter inputs

        if (book == null) {
            throw new RuntimeException("Book ID: " + bookId + " does not exist. Please try again.");
        }

        return book;
    }

    //TODO create endpoint to save new book

    //TODO create endpoint to delete book by id

    //TODO create endpoint to update book
}
