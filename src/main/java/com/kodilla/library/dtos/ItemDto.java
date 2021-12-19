package com.kodilla.library.dtos;

import com.kodilla.library.storage.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private String title;
    private ItemStatus status;
}
