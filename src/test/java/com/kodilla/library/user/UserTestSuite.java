package com.kodilla.library.user;

import com.kodilla.library.repositories.UserRepository;
import com.kodilla.library.service.UserService;
import com.kodilla.library.users.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User userExample = new User(
            1L, "UserName1", "UserLastname1", LocalDateTime.now());

    private User userExample1 = new User(
            2L, "UserName2", "UserLastname2", LocalDateTime.now().minusDays(120L));

    private User userExample2 = new User(
            3L, "UserName3", "UserLastname3", LocalDateTime.now().minusDays(490L));

    @Test
    public void testAddNewUser() {
        //given

        //when
        User newUser = userRepository.save(userExample);
        User user = userService.addNewUser(newUser);
        //then
        assertAll(
                () -> assertEquals(user.getLastname(), userExample.getLastname()),
                () -> assertEquals(user.getId(), userExample.getId()),
                () -> assertEquals(user.getCreated(), userExample.getCreated()),
                () -> assertEquals(user.getName(), userExample.getName())
        );
    }

    @Test
    public void testDeleteUserById() {
        //given

        //when
        userService.deleteUserById(userExample.getId());
        boolean doesExist = userRepository.existsById(userExample.getId());
        //then
        assertFalse(doesExist);
    }

    @Test
    public void testUserChronoList() {
        //given
        List<User> allByCreated_chronology = new ArrayList<>();
        allByCreated_chronology.add(userExample);
        allByCreated_chronology.add(userExample2);
        allByCreated_chronology.add(userExample1);
        //when
        allByCreated_chronology = userRepository.findAllByCreated_Chronology();
        List<User> users = userService.showAllUsersByCreatedDateASC();
        //then
        assertEquals(allByCreated_chronology, users);
    }
}
