package com.kodilla.library.repositories;

import com.kodilla.library.book.Borrow;
import org.springframework.data.repository.CrudRepository;

public interface BorrowRepository extends CrudRepository<Borrow, Long> {

}
