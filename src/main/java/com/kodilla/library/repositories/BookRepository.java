package com.kodilla.library.repositories;

import com.kodilla.library.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByAuthor(Book book);
    List<Book> findBooksByTitle(String title);
    Book deleteById();
}
