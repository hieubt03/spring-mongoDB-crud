package com.example.spring_mongoDB_crud.controller;

import com.example.spring_mongoDB_crud.model.BookModel;
import com.example.spring_mongoDB_crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String homePage() {
        return "books";
    }
    @GetMapping("addBook")
    public String createBookForm(Model model) {
        model.addAttribute("book", new BookModel());
        return "addBook";
    }
    @PostMapping("/addBook")
    public String createBook(@ModelAttribute BookModel book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BookModel> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable String id, Model model) {
        BookModel book = bookService.getBookById(id).orElse(null);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/update")
    public String updateBook(@PathVariable String id, @ModelAttribute BookModel book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
