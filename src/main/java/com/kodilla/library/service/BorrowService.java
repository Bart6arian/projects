package com.kodilla.library.service;

import com.kodilla.library.book.Borrow;
import com.kodilla.library.repositories.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private BorrowRepository borrowRepository;
    private Borrow borrow;

    public Optional<Borrow> bookBorrowById(final Long id) {
        return borrowRepository.findById(id);
    }

    public Borrow setBorrowDate(final Borrow borrow) {
       borrow.setBorrowDate(LocalDateTime.now());
       return borrowRepository.save(borrow);
    }

    public void bookTurnBackDeleteBorrow(final Borrow borrow) {
        borrowRepository.delete(borrow);
    }
}
