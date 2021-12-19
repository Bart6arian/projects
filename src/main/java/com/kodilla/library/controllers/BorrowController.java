package com.kodilla.library.controllers;

import com.kodilla.library.book.Borrow;
import com.kodilla.library.dtos.BorrowDto;
import com.kodilla.library.exceptions.BorrowNotFoundException;
import com.kodilla.library.mappers.BorrowMapper;
import com.kodilla.library.repositories.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "v1/borrow")
public class BorrowController {

    private BorrowMapper borrowMapper;
    private BorrowRepository borrowRepository;

    @RequestMapping(method = RequestMethod.GET, name = "getAllBorrows")
    public List<BorrowDto> getAllBorrows() {
        List<Borrow> borrowList = (List<Borrow>) borrowRepository.findAll();
        return borrowMapper.mapToBorrowDtoList(borrowList);
    }

    @RequestMapping(method = RequestMethod.GET, name = "findBorrowById")
    public BorrowDto findById(final Long id) throws BorrowNotFoundException {
        return borrowMapper.mapToBorrowDto(
                borrowRepository.findById(id).orElseThrow(BorrowNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, name = "deleteBorrow")
    public void delete(final Borrow borrow) {
        borrowRepository.delete(borrow);
    }

    @RequestMapping(method = RequestMethod.POST, name = "addNewBorrow")
    public BorrowDto addNewBorrow(final Borrow borrow) {
        return borrowMapper.mapToBorrowDto(borrowRepository.save(borrow));
    }

    @RequestMapping(method = RequestMethod.PUT, name = "updateBorrow")
    public BorrowDto updateBorrow(@RequestBody BorrowDto borrowDto) {
        Borrow borrow = borrowMapper.mapToBorrow(borrowDto);
        Borrow savedBorrow = borrowRepository.save(borrow);
        return borrowMapper.mapToBorrowDto(savedBorrow);
    }
}
