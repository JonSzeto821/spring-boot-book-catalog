package com.example.springbooks.bookcrud.controller;

import com.example.springbooks.bookcrud.entity.Book;
import com.example.springbooks.bookcrud.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormToAddBook")
    public String showFormToAddBook(Model theModel) {
        // create new model attribute to bind form data
        Book theNewBook = new Book();

        theModel.addAttribute("book", theNewBook);

        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book theBook) {
        //capture the user input information into a new book object and save
        bookService.save(theBook);

        //send the user back to the book list screen upon form submit
        return "redirect:/books/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateBookDetails(@RequestParam("bookId") int id, Model theModel) {
        // get the book by id from the service layer
        Book book = bookService.findById(id);

        // set the employee in the model to populate the form fields
        theModel.addAttribute("book", book);

        //send user to the form
        return "books/book-form";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int id) {
        bookService.deleteById(id);

        return "redirect:/books/list";
    }

    @GetMapping("/authors")
    public String showAuthorsPage() {

        return "books/authors";
    }

    @GetMapping("/admin")
    public String showAdminPage() {

        return "books/admin";
    }
}
