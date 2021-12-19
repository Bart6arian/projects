package com.kodilla.library.controllers;

import com.kodilla.library.book.Book;
import com.kodilla.library.dtos.BookDto;
import com.kodilla.library.dtos.UserDto;
import com.kodilla.library.exceptions.BookNotFoundException;
import com.kodilla.library.mappers.BookMapper;
import com.kodilla.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/book")
public class BookController {

    private BookMapper bookMapper;
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, name = "getBooksByAuthor")
    public List<BookDto> getBooksByAuthor(final Book book) {
       List<Book> bookList = bookRepository.findAllByAuthor(book);
       return bookMapper.mapToBookDtoList(bookList);
    }

    @RequestMapping(method = RequestMethod.GET, name = "getBookByTitle")
    public List<BookDto> getBookByTitle(final String title) {
        List<Book> bookList = bookRepository.findBooksByTitle(title);
        return bookMapper.mapToBookDtoList(bookList);
    }

    @RequestMapping(method = RequestMethod.GET, name = "getBookById")
    public BookDto getBookById(final Long id) throws BookNotFoundException {
        return bookMapper.mapToBookDto(
                bookRepository.findById(id).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, name = "addNewBook")
    public BookDto addNewBook(final Book book) {
        return bookMapper.mapToBookDto(bookRepository.save(book));
    }

    @RequestMapping(method = RequestMethod.DELETE, name = "deleteBook")
    public void deleteBook(final Book book) {
        bookRepository.delete(book);
    }

    @RequestMapping(method = RequestMethod.PUT, name = "bookTurnBack")
    public BookDto bookTurnedBack(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.mapToBookDto(savedBook);
    }

}
