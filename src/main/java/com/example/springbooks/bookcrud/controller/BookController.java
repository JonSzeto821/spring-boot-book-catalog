package com.example.springbooks.bookcrud.controller;

import com.example.springbooks.bookcrud.entity.Book;
import com.example.springbooks.bookcrud.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {
        // get the books from db
        List<Book> theBooks = bookService.findAll();

        // add to the spring model
        theModel.addAttribute("books", theBooks);

        return "books/list-books";
    }
}
