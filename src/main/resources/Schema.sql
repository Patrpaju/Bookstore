/*
CREATE TABLE IF NOT EXISTS book (
    book_id int(5) NOT NULL AUTO_INCREMENT,
    title varchar(50) DEFAULT NULL,
    author varchar(50) DEFAULT NULL,
    isbn varchar(50) DEFAULT NULL,
    publicationyear varchar(50) DEFAULT NULL,
    PRIMARY KEY(book_id)
    );
    
CREATE TABLE IF NOT EXISTS category (
 	category_id int(5) NOT NULL AUTO_INCREMENT,
 	name varchar(50) DEFAULT NULL,
 	book_id int(5), NOT NULL,
 	PRIMARY KEY(category_id),
    FOREIGN KEY(book_id),
    	REFERENCES book (book_id)
 	);
 	
 CREATE TABLE IF NOT EXISTS UserTable (
 	user_id int (5) NOT NULL AUTO_INCREMENT,
 	username varchar (50) DEFAULT NULL,
 	passwordHash varchar (50) DEFAULT NULL,
 	role varchar (50) DEFAULT NULL,
 	PRIMARY KEY(user_id)
 	);
*/ 	
 	
 	
 	