package com.kodilla.library.service;

import com.kodilla.library.book.Book;
import com.kodilla.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findByAuthor(final Book book) {
        return bookRepository.findAllByAuthor(book);
    }

    public List<Book> findByTitle(final String title) {
        return bookRepository.findBooksByTitle(title);
    }

    public Book addNewBook(final Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(final Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> isTitleAvailable(final String title) {
        return bookRepository.findBooksByTitle(title);
    }

    public Book deleteById(final Long id) {
        return bookRepository.deleteById();
    }
}
