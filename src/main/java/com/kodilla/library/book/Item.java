package com.kodilla.library.book;

import com.kodilla.library.storage.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_stack")
public class Item {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;
    private String title;
    private ItemStatus status;

}
