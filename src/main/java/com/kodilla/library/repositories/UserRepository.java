package com.kodilla.library.repositories;

import com.kodilla.library.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByCreated_Chronology();
}
