package com.kodilla.library.book;

import com.kodilla.library.storage.Storage;
import com.kodilla.library.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books_out")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storage")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime borrowDate;
    private LocalDateTime turnBackDate;


}
