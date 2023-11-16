CREATE TABLE IF NOT EXISTS Book (
    book_id int(5) NOT NULL AUTO_INCREMENT,
    title varchar(50) DEFAULT NULL,
    author varchar(50) DEFAULT NULL,
    publicationYear varchar(50) DEFAULT NULL,
    isbn varchar(50) DEFAULT NULL,
    price varchar(50) DEFAULT NULL,
    PRIMARY KEY(book_id)
    );
    
   CREATE TABLE IF NOT EXISTS category (
    category_id int(5) NOT NULL AUTO_INCREMENT,
    name varchar(50) DEFAULT NULL,
    /* book_id int(5) NOT NULL,
    CONSTRAINT FK_Book_Id FOREIGN KEY(book_id) REFERENCES Book(book_id) */
    PRIMARY KEY(category_id)
    );