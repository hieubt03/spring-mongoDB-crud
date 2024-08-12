package com.example.spring_mongoDB_crud.service;

import com.example.spring_mongoDB_crud.model.BookModel;
import com.example.spring_mongoDB_crud.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public BookModel createBook(BookModel book) {
        return bookRepo.save(book);
    }

    public List<BookModel> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<BookModel> getBookById(String id) {
        return bookRepo.findById(id);
    }

    public BookModel updateBook(String id, BookModel book) {
        if (bookRepo.existsById(id)) {
            book.setId(id);
            return bookRepo.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }
}
