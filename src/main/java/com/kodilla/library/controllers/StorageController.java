package com.kodilla.library.controllers;

import com.kodilla.library.book.Book;
import com.kodilla.library.dtos.StorageDto;
import com.kodilla.library.exceptions.StorageNotFoundException;
import com.kodilla.library.mappers.StorageMapper;
import com.kodilla.library.repositories.StorageRepository;
import com.kodilla.library.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "v1/storage")
public class StorageController {

    private StorageRepository storageRepository;
    private StorageMapper storageMapper;

    @RequestMapping(method = RequestMethod.GET, name = "getStorageById")
    public StorageDto getStorageById(final Long id) throws StorageNotFoundException {
        return storageMapper.mapToStorageDto(
                storageRepository.findById(id).orElseThrow(StorageNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, name = "deleteStorage")
    public void deleteStorageById(final Long id) {
        storageRepository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, name = "updateStorage")
    public StorageDto updateStorage(@RequestBody StorageDto storageDto) {
        Storage storage = storageMapper.mapToStorage(storageDto);
        Storage savedStorage = storageRepository.save(storage);
        return storageMapper.mapToStorageDto(savedStorage);
    }

    @RequestMapping(method = RequestMethod.POST, name = "addNewStorage")
    public StorageDto addNewStorage(final Storage storage) {
        return storageMapper.mapToStorageDto(storageRepository.save(storage));
    }

    @RequestMapping(method = RequestMethod.POST, name = "saveNewBook")
    public StorageDto saveNewBookInStorage(final Book book, final Storage storage) {
        return storageMapper.mapSaveBookToStorageDto(
                storageRepository.saveBook(book), storageRepository.save(storage));
    }

}
