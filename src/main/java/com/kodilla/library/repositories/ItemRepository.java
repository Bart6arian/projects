package com.kodilla.library.repositories;

import com.kodilla.library.book.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item itemQuantitySave(Item item, int q);
}
