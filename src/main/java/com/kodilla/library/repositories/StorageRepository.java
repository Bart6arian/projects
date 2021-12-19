package com.kodilla.library.repositories;

import com.kodilla.library.book.Book;
import com.kodilla.library.storage.ItemStatus;
import com.kodilla.library.storage.Storage;
import org.springframework.data.repository.CrudRepository;

public interface StorageRepository extends CrudRepository<Storage, Long> {
    Book saveBook(Book book);
    ItemStatus findByItemStatus(Book book);
    Storage findByBook_Title();
    Storage isAvailable(String title);
}
