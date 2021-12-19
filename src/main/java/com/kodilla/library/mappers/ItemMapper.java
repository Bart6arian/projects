package com.kodilla.library.mappers;

import com.kodilla.library.book.Item;
import com.kodilla.library.dtos.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemMapper {

    public Item mapToItem(final ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getTitle(),
                itemDto.getStatus()
        );
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getId(),
                item.getTitle(),
                item.getStatus()
        );
    }

    public List<ItemDto> mapToItemDtoList(final List<Item> items) {
        return items.stream()
                .map(this::mapToItemDto)
                .collect(Collectors.toList());
    }
}
