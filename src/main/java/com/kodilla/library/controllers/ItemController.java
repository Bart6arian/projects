package com.kodilla.library.controllers;

import com.kodilla.library.book.Item;
import com.kodilla.library.dtos.ItemDto;
import com.kodilla.library.exceptions.ItemNotFoundException;
import com.kodilla.library.mappers.ItemMapper;
import com.kodilla.library.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "v1/item")
public class ItemController {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.GET, name = "getItemById")
    public ItemDto getItemById(final Long itemId) throws ItemNotFoundException {
        return itemMapper.mapToItemDto(itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, name = "addNewItem")
    public ItemDto addNewItem(final Item item) {
        return itemMapper.mapToItemDto(itemRepository.save(item));
    }

    @RequestMapping(method = RequestMethod.DELETE, name = "deleteItem")
    public void deleteItem(final Item item) {
        itemRepository.delete(item);
    }

    @RequestMapping(method = RequestMethod.GET, name = "getAllItems")
    public List<ItemDto> getAllItems() {
        List<Item> items = (List<Item>) itemRepository.findAll();
        return itemMapper.mapToItemDtoList(items);
    }

    @RequestMapping(method = RequestMethod.PUT, name = "updateQuantity")
    public ItemDto updateItemQuantity(final ItemDto itemDto, final int quantity) {
        Item item = itemMapper.mapToItem(itemDto);
        Item update = itemRepository.itemQuantitySave(item, quantity);
        Item savedItem = itemRepository.save(update);
        return itemMapper.mapToItemDto(savedItem);
    }
}
