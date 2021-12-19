package com.kodilla.library.service;

import com.kodilla.library.book.Book;
import com.kodilla.library.repositories.StorageRepository;
import com.kodilla.library.storage.ItemStatus;
import com.kodilla.library.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService {

    private StorageRepository storageRepository;

    public Storage saveStorage(final Storage storage) {
        return storageRepository.save(storage);
    }

    public Book saveBookInStorage(final Book book) {
        return storageRepository.saveBook(book);
    }

    public ItemStatus findItemStatusOfGivenBook(final Book book) {
        return storageRepository.findByItemStatus(book);
    }

    public void deleteBookFromStorageById(final Long bookId) {
        storageRepository.deleteById(bookId);
    }

    public List<Storage> findAllOnStorage() {
        return (List<Storage>) storageRepository.findAll();
    }

    public Storage findAvailableByTitle(String title) {
        title = String.valueOf(storageRepository.findByBook_Title());
        return storageRepository.isAvailable(title);
    }

}
