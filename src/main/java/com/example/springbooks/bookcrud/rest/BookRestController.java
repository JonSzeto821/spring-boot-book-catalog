package com.example.springbooks.bookcrud.rest;

import com.example.springbooks.bookcrud.entity.Book;
import com.example.springbooks.bookcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book theBook) {
        if (theBook == null) {
            throw new RuntimeException("Please provide book details!");
        }

        theBook.setId(0);

        return bookService.save(theBook);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteById(@PathVariable int bookId) {
        Book tempBook = bookService.findById(bookId);

        if (tempBook == null) {
            throw new RuntimeException("Book ID: " + bookId + " does not exist");
        }

        bookService.deleteById(bookId);

        return tempBook.getTitle() + " has been removed from the library";
    }

    @PutMapping("/books")
    public Book updateBookDetails(@RequestBody Book theBook) {
        if (theBook == null) {
            throw new RuntimeException("Please provide employee information!");
        }

        return bookService.save(theBook);
    }
}
