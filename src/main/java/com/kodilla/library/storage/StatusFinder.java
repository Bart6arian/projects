package com.kodilla.library.storage;

import com.kodilla.library.book.Book;

public class StatusFinder {

    private ItemStatus itemStatus;
    private Storage storage;

    public ItemStatus checkItemStatus(Storage storage) {
        if(storage.getItemStatus() != ItemStatus.AVAILABLE) {
            return isAvailable(storage.getBook());
        }
        else
            return ItemStatus.AVAILABLE;
    }


    private ItemStatus isAvailable(Book book) {

        switch (ItemStatus.AVAILABLE) {
            case LOST:
                System.out.println("Book " + book.getId() +" is lost");
                break;
            case OUT_OF_STORAGE:
                System.out.println("Book " + book.getId() + " is out of storage");
                break;
            case DESTROYED:
                System.out.println("Book " + book.getId() + " was destroyed");
                break;
            default:
                System.out.println("Book " + book.getId() + " is available");
                break;
        }
        return null;
    }
}
