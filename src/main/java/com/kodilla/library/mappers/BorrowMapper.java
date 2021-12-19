package com.kodilla.library.mappers;

import com.kodilla.library.book.Borrow;
import com.kodilla.library.dtos.BorrowDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowMapper {

    public Borrow mapToBorrow(final BorrowDto borrowDto) {
        return new Borrow(
                borrowDto.getId(),
                borrowDto.getStorage(),
                borrowDto.getUserId(),
                borrowDto.getBorrowDate(),
                borrowDto.getTurnBackDate()
        );
    }

    public BorrowDto mapToBorrowDto(final Borrow borrow) {
        return new BorrowDto(
                borrow.getId(),
                borrow.getStorage(),
                borrow.getUser(),
                borrow.getBorrowDate(),
                borrow.getTurnBackDate()
        );
    }

    public List<BorrowDto> mapToBorrowDtoList(final List<Borrow> borrowList) {
        return borrowList.stream()
                .map(this::mapToBorrowDto)
                .collect(Collectors.toList());
    }
}
