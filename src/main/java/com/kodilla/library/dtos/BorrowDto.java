package com.kodilla.library.dtos;

import com.kodilla.library.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.kodilla.library.users.User;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDto {

    private Long id;
    private Storage storage;
    private User userId;
    private LocalDateTime borrowDate;
    private LocalDateTime turnBackDate;

}
