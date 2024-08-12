package com.example.spring_mongoDB_crud.repository;

import com.example.spring_mongoDB_crud.model.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<BookModel, String> {

}
