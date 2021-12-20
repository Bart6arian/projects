package com.kodilla.library.book;

import com.kodilla.library.repositories.BookRepository;
import com.kodilla.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTestSuite {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @Test
    public void testAddNewTitle() {
        //given
        LocalDate lc = LocalDate.of(1999, 4, 12);
        Book book = new Book(1L, "title1", "author1", lc);
        //then
        Book savedBook = bookService.addNewBook(book);
        String savedBookTitle = "title1";
        //when
        assertEquals(savedBookTitle, savedBook.getTitle());
        assertEquals(1L, savedBook.getId());
        assertEquals(lc, savedBook.getYearOfPublication());
    }

    @Test
    public void testDeleteBookById() {
        //given
        LocalDate lc = LocalDate.of(1999, 4, 12);
        Book book = new Book(1L, "title1", "author1", lc);
        //then
        Book savedBook = bookService.deleteById(book.getId());
        boolean isStillInRepo = bookRepository.existsById(savedBook.getId());
        //when
        assertFalse(isStillInRepo);
    }

    @Test
    public void testIfTitleIsAvailable() {
        //given
        LocalDate lc = LocalDate.of(1999, 4, 12);
        Book book = new Book(1L, "title1", "author1", lc);
        //then
        Book savedBook = bookService.addNewBook(book);
        boolean isAvailable = bookRepository.existsById(savedBook.getId());
        //when
        assertTrue(isAvailable);
    }

}
