package com.kodilla.library.dtos;

import com.kodilla.library.book.Book;
import com.kodilla.library.storage.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageDto {

    private Long id;
    private Book book;
    private ItemStatus itemStatus;
}
