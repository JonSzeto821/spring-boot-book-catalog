package com.example.springbooks.bookcrud.dao;

import com.example.springbooks.bookcrud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

}