package com.example.bookmanagement.service;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.example.bookmanagement.exception.BookNotFoundException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with id: " + id));
    }
    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        bookRepository.deleteById(id);
    }
}