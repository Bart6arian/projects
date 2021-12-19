package com.kodilla.library.service;

import com.kodilla.library.book.Item;
import com.kodilla.library.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public Item addNextItem(final Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(final Long itemId) {
        itemRepository.deleteById(itemId);
    }

    public Item setItemQuantityWhileAddNewItem(final Item item, int quantity) {
        int x = 0;
        while(x < quantity) {
            itemRepository.save(item);
            x++;
        }
        return (Item) itemRepository.findAll();
    }
}
