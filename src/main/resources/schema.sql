CREATE TABLE USER
(
    ID              SERIAL PRIMARY KEY,
    FIRSTNAME       VARCHAR(60) NOT NULL,
    LASTNAME        VARCHAR(60) NOT NULL,
    ACCOUNT_CREATED TIMESTAMP NOT NULL
);

CREATE TABLE BOOK
(
    ID               SERIAL PRIMARY KEY,
    TITLE            VARCHAR(150) NOT NULL,
    AUTHOR           VARCHAR(150) NOT NULL,
    PUBLICATION_YEAR DATETIME NOT NULL
);

CREATE TABLE ITEM
(
    ID      SERIAL PRIMARY KEY,
    BOOK_ID BIGINT UNSIGNED NOT NULL,
    STATUS  VARCHAR(20) NOT NULL,
    FOREIGN KEY (book_id) REFERENCES BOOK (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE BORROW
(
    ID          SERIAL PRIMARY KEY,
    ITEM_ID  BIGINT UNSIGNED NOT NULL,
    USER_ID     BIGINT UNSIGNED NOT NULL,
    BORROW_DATE TIMESTAMP NOT NULL,
    BACK_DATE   TIMESTAMP NOT NULL,
    FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (USER_ID) REFERENCES USER (ID) ON DELETE CASCADE ON UPDATE CASCADE
);