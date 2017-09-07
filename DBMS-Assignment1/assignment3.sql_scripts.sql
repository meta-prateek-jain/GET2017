-- Inserting data in tables 
INSERT INTO members(name, addressline1, addressline2, category) VALUES ('mahesh', 'sec 11', 'udaipur', 'M'),('sunita', 'pratap nagar', 'sitapura', 'F'),('Keshav Sharma', 'Jwahar nagar', 'Jaipur', 'M'),('Neel Singhal', 'Sector-3', 'Gopalpura', 'F'),('Shivam Lalwani', 'Sector-13', 'Pratap Nagar', 'M');
INSERT INTO authors(name) VALUES ('Johnson White'),('Cheryl carson'),('J. K. Rowling'),('Harold Robbins'),('William Shakespeare'); 
INSERT INTO publishers(name) VALUES ('New Moon Books'),('Binnet & Harley'),('NotionPress'),('Genius Publications'),('Ashirwad Publications');
INSERT INTO subjects(name) VALUES ('Computer'),('Physics'),('DBMS'),('JAVA'),('JavaScript');
INSERT INTO titles(name, subject_id, publisher_id) VALUES ('Cooking With Computers', 1, 3),('Secrets of Silicon Valley', 2, 1),('JAVA - Basics', 4, 2),('Know Database Management', 3, 4),('Vedic Mathematics', 5, 5);
INSERT INTO books(title_id, purchase_date, price, status) VALUES (1, '2016-05-20 13.00.00.00', 100.00, 'available'),(2, '2017-02-20 3.00.00.00', 200.00, 'available'),(3, '2016-05-16 12.00.00.00', 215.00, 'AVAILABLE'),(4, '2016-08-16 12.00.00.00', 415.00, 'AVAILABLE'),(5, '2015-05-16 12.00.00.00', 215.00, 'AVAILABLE'); 
INSERT INTO title_author(title_id, author_id) VALUES (1, 2),(2, 4),(3, 1),(4, 5),(5, 3);
INSERT INTO book_issue(accession_no, member_id) VALUES (1, 1),(2, 3),(3, 5),(4, 2);
INSERT INTO book_return(accession_no, member_id, issue_date) (SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 1  AND accession_no = 1);
INSERT INTO book_return(accession_no, member_id, issue_date) (SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 2 AND accession_no = 4);

-- Seeting safe updates to zero for updating data without where statement
SET SQL_SAFE_UPDATES = 0; 

--  Changing data of table members
UPDATE members SET addressline2 = 'Jaipur';
UPDATE members SET addressline1 = 'EPIP, Sitapura' WHERE category = 'F';

--  Delete all the rows from Publishers table.
DELETE FROM publishers;

--  Reseting the table auto increment 
ALTER TABLE publishers AUTO_INCREMENT = 1;
ALTER TABLE books AUTO_INCREMENT = 1;
ALTER TABLE titles AUTO_INCREMENT = 1;
ALTER TABLE title_author AUTO_INCREMENT = 1;
ALTER TABLE book_issue AUTO_INCREMENT = 1;
ALTER TABLE book_return AUTO_INCREMENT = 1;

-- Insert the sample data back in publishers table using substitution variables. but after setting values in the variables
SET @publisher_name1 = 'New Moon Books';
SET @publisher_name2 = 'Binnet & Harley';
SET @publisher_name3 = 'NotionPress';
SET @publisher_name4 = 'Genius Publications';
SET @publisher_name5 = 'Ashirwad Publications';

INSERT INTO publishers(name) VALUES (@publisher_name1),(@publisher_name2),(@publisher_name3),(@publisher_name4),(@publisher_name5);

-- Inserting data in other tables too whose data is deleted by deleting the publishers table
INSERT INTO titles(name, subject_id, publisher_id) VALUES ('Cooking With Computers', 1, 3),('Secrets of Silicon Valley', 2, 1),('JAVA - Basics', 4, 2),('Know Database Management', 3, 4),('Vedic Mathematics', 5, 5);
INSERT INTO books(title_id, purchase_date, price, status) VALUES (1, '2016-05-20 13.00.00', 100.00, 'AVAILABLE'),(2, '2017-02-20 3.00.00', 200.00, 'AVAILABLE'),(3, '2016-05-16 12.00.00', 215.00, 'AVAILABLE'),(4, '2016-08-16 12.00.00', 415.00, 'AVAILABLE'),(5, '2015-05-16 12.00.00', 215.00, 'AVAILABLE'); 
INSERT INTO title_author(title_id, author_id) VALUES (1, 2),(2, 4),(3, 1),(4, 5),(5, 3);
INSERT INTO book_issue(accession_no, member_id) VALUES (1, 1),(2, 3),(3, 5),(4, 2);
INSERT INTO book_return(accession_no, member_id, issue_date) (SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 1  AND accession_no = 1);
INSERT INTO book_return(accession_no, member_id, issue_date) (SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 2 AND accession_no = 4);

-- Delete those rows of Titles table belonging to Publisher with publisher_id = 1
-- DELETE FROM titles WHERE publisher_id = 1;