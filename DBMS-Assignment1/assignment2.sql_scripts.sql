-- Creating the database 
CREATE DATABASE library_information_system;

-- Selecting the database
Use library_information_system;

-- Creating all tables in database library_information_system
CREATE TABLE members(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    addressline1 VARCHAR(100),
    addressline2 VARCHAR(100),
    category VARCHAR(50)
);
CREATE TABLE publishers(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE authors(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE subjects(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE titles(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    subject_id INT NOT NULL,
    publisher_id INT NOT NULL,
    CONSTRAINT fk_titles_publisher_id FOREIGN KEY(publisher_id) REFERENCES publishers(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_titles_subject_id FOREIGN KEY(subject_id) REFERENCES subjects(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE title_author(
    title_id INT NOT NULL ,
    author_id INT NOT NULL,
    PRIMARY KEY(title_id, author_id),
    CONSTRAINT fk_title_id FOREIGN KEY(title_id) REFERENCES titles(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_author_id FOREIGN KEY(author_id) REFERENCES authors(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE books(
    accession_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title_id INT NOT NULL,
    purchase_date TIMESTAMP,
    price DOUBLE NOT NULL,
    status VARCHAR(100),
    CONSTRAINT fk_books_title_id FOREIGN KEY(title_id) REFERENCES titles(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE book_issue(
    issue_date TIMESTAMP,
    accession_no INT NOT NULL,
    member_id INT NOT NULL,
    due_date TIMESTAMP NOT NULL,
    PRIMARY KEY(issue_date, accession_no, member_id),
    CONSTRAINT fk_books_issue_accession_no FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_books_issue_member_id FOREIGN KEY(member_id) REFERENCES members(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE book_return(
    return_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    accession_no INT NOT NULL,
    member_id INT NOT NULL,
    issue_date TIMESTAMP NOT NULL,
    PRIMARY KEY(return_dt, accession_no, member_id),
    CONSTRAINT fk_books_return_accession_no FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_books_return_member_id FOREIGN KEY(member_id) REFERENCES members(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_books_return_issue_date FOREIGN KEY(issue_date) REFERENCES book_issue(issue_date) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Altering the table book_issue default values
ALTER TABLE book_issue MODIFY issue_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Using delimiter to set default value of due date in table book_issue to current darte + 15 days
DELIMITER $$

CREATE TRIGGER dt_15days

BEFORE INSERT ON `book_issue` FOR EACH ROW

BEGIN

    SET NEW.due_date = NOW() + INTERVAL 15 DAY;

END;

$$

DELIMITER ;

-- Drop the members table before dropping drop foriegn key from child table
ALTER TABLE book_issue DROP FOREIGN KEY fk_books_issue_member_id;
ALTER TABLE book_return DROP FOREIGN KEY fk_books_return_member_id;
DROP TABLE members;

-- Creating again members table and setting back the foreign keys
CREATE TABLE members(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    addressline1 VARCHAR(100),
    addressline2 VARCHAR(100),
    category VARCHAR(50)
);
ALTER TABLE book_issue ADD CONSTRAINT fk_books_issue_member_id FOREIGN KEY(member_id) REFERENCES members(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE book_return ADD CONSTRAINT fk_books_return_member_id  FOREIGN KEY(member_id) REFERENCES members(id) ON DELETE CASCADE ON UPDATE CASCADE;
