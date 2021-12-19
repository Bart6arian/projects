package com.kodilla.library.service;

import com.kodilla.library.repositories.UserRepository;
import com.kodilla.library.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> showAllUsersByCreatedDateASC() {
        return userRepository.findAllByCreated_Chronology();
    }

    public User findUserById(final Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }

    public User addNewUser(final User user) {
        return userRepository.save(user);
    }

    public boolean isUserAvailable(final Long id) {
        return userRepository.existsById(id);
    }
}
