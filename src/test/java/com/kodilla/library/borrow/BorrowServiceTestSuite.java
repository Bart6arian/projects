package com.kodilla.library.borrow;

import com.kodilla.library.book.Book;
import com.kodilla.library.book.Borrow;
import com.kodilla.library.repositories.BookRepository;
import com.kodilla.library.repositories.BorrowRepository;
import com.kodilla.library.repositories.StorageRepository;
import com.kodilla.library.repositories.UserRepository;
import com.kodilla.library.service.BorrowService;
import com.kodilla.library.storage.ItemStatus;
import com.kodilla.library.storage.Storage;
import com.kodilla.library.users.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BorrowServiceTestSuite {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StorageRepository storageRepository;

    private User userExample = new User(1L, "UserName1", "UserLastname1", LocalDateTime.now());
    private Book bookExample = new Book(1L, "Title1", "Author1", LocalDate.now());
    private Storage storage = new Storage(1L, bookExample, ItemStatus.AVAILABLE);

    @BeforeEach
    void fillData() {
        storageRepository.save(storage);
    }

    @AfterEach
    void clearStorage() {
        storageRepository.deleteAll();
    }

    @Test
    public void testAddNewBorrowInRepo() {
        //given
        Borrow borrow = new Borrow(1L, storage, userExample, LocalDateTime.now(), LocalDateTime.now().minusDays(20L));
        //then
        Borrow savedBorrow = borrowRepository.save(borrow);
        //when
        assertEquals(savedBorrow.getBorrowDate(), borrow.getBorrowDate());
        assertEquals(savedBorrow.getId(), borrow.getId());
    }

    @Test
    public void testDeleteBorrow() {
        //given
        Borrow borrow = new Borrow(1L, storage, userExample, LocalDateTime.now(), LocalDateTime.now().minusDays(20L));
        //then
        borrowService.setBorrowDate(borrow);
        boolean doesExist = borrowRepository.existsById(borrow.getId());
        //when
        assertFalse(doesExist);
    }

    @Test
    public void fullTestTurnBack() {
        //given
        Borrow borrow = new Borrow(1L, storage, userExample, LocalDateTime.now(), LocalDateTime.now().minusDays(20L));
        borrowRepository.save(borrow);
        //then
        borrowService.bookTurnBackDeleteBorrow(borrow);
        boolean isDelatedBorrow = borrowRepository.existsById(borrow.getId());
        //when
        assertFalse(isDelatedBorrow);
    }
}
