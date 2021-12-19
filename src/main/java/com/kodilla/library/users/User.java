package com.kodilla.library.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user", sequenceName = "user_seq", allocationSize = 50)
    private Long id;
    private String name;
    private String lastname;
    private LocalDateTime created;


}
