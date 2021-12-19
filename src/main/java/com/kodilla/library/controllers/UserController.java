package com.kodilla.library.controllers;

import com.kodilla.library.dtos.UserDto;
import com.kodilla.library.exceptions.UserNotFoundException;
import com.kodilla.library.mappers.UserMapper;
import com.kodilla.library.repositories.UserRepository;
import com.kodilla.library.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "v1/user")
public class UserController {

    private UserMapper userMapper;
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, name = "getAllUsers")
    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return userMapper.mapToUserDtoList(users);
    }

    @RequestMapping(method = RequestMethod.GET, name = "getUserById")
    public UserDto getUserById(final Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(
                userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, name = "deleteUser")
    public void deleteUser(final User user) {
        userRepository.delete(user);
    }

    @RequestMapping(method = RequestMethod.POST, name = "addNewUser")
    public UserDto addNewUser(final User user) {
        return userMapper.mapToUserDto(userRepository.save(user));
    }

    @RequestMapping(method = RequestMethod.GET, name = "getUsersChrono")
    public List<User> getUsersChronologically() {
        return userRepository.findAllByCreated_Chronology();
    }

    @RequestMapping(method = RequestMethod.PUT, name = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }
}
