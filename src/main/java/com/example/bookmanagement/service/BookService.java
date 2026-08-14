package com.example.bookmanagement.service;

import com.example.bookmanagement.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void deleteBook(Long id);
}