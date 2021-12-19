package com.kodilla.library.mappers;

import com.kodilla.library.book.Book;
import com.kodilla.library.dtos.StorageDto;
import com.kodilla.library.storage.Storage;
import org.springframework.stereotype.Service;

@Service
public class StorageMapper {

    public Storage mapToStorage(final StorageDto storageDto) {
        return new Storage(
                storageDto.getId(),
                storageDto.getBook(),
                storageDto.getItemStatus()
        );
    }

    public StorageDto mapToStorageDto(final Storage storage) {
        return new StorageDto(
                storage.getId(),
                storage.getBook(),
                storage.getItemStatus()
        );
    }

    public StorageDto mapSaveBookToStorageDto(final Book book, final Storage storage) {
        return new StorageDto(
                storage.getId(),
                (new Book(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYearOfPublication())),
                storage.getItemStatus()
        );
    }

}
