-- Selecting the database
USE library_information_system;

-- Inserting the sample data to table
INSERT INTO authors(name) 
VALUES ('S. Balaguruswami'),('R D Sharma'),('Henry');

INSERT INTO titles (name, subject_id, publisher_id) 
VALUES ('Physics', 3, 3),('OOP IN JAVA', 4, 2);

INSERT INTO title_author (title_id, author_id) 
VALUES (6, 8),(7, 6);

INSERT INTO book_issue(issue_date,accession_no, member_id) 
VALUES ('2017-03-15 16:33:17',3, 2),('2017-03-10 16:33:17',2, 2),
		('2017-01-31 16:33:17',3, 4),('2017-02-05 16:33:17',2, 1);

UPDATE book_issue SET due_date = '2017-05-30 16:33:17' WHERE accession_no = 3 and member_id = 2;
UPDATE book_issue SET due_date = '2017-06-25 10:33:17' WHERE accession_no = 2 and member_id = 2;
UPDATE book_issue SET due_date = '2017-04-15 16:33:17' WHERE accession_no = 3 and member_id = 4;
UPDATE book_issue SET due_date = '2017-02-20 16:33:17' WHERE accession_no = 2 and member_id = 1;

INSERT INTO book_return(accession_no, member_id, issue_date) 
	(SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 1  AND accession_no = 2);
INSERT INTO book_return(accession_no, member_id, issue_date) 
	(SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 2  AND accession_no = 2);
INSERT INTO book_return(accession_no, member_id, issue_date) 
	(SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 3  AND accession_no = 4);
INSERT INTO book_return(accession_no, member_id, issue_date) 
	(SELECT accession_no, member_id, issue_date FROM book_issue WHERE member_id = 4  AND accession_no = 1);

-- Display information on books issued for more than 2 moths
SELECT m.name AS'Member name', m.id AS 'Member id', t.name AS 'Title', br.accession_no, br.issue_date, 
	TIMESTAMPDIFF(MONTH, br.issue_date,br.return_date) AS 'Issued For (In Months)' 
	FROM book_return br 
	JOIN members m ON m.id = br.member_id 
	JOIN books b ON b.accession_no = br.accession_no 
	JOIN titles t ON t.id = b.title_id  
	WHERE TIMESTAMPDIFF(MONTH, br.issue_date,br.return_date) > 2;  

-- Display those rows from members table having maximum length for member name
SELECT MAX(LENGTH(name)) AS 'Length of name', name 
	FROM members 
	WHERE LENGTH(name) = (SELECT MAX(LENGTH(name)) FROM members);

-- Display count of number of book issued so far
SELECT COUNT(issue_date) AS 'Number of books issued' FROM book_issue;