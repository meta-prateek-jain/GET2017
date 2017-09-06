-- Inserting the sample data
INSERT INTO books(accession_no, title_id, purchase_date, price, status)
    VALUES (6, 2, '2016-02-20 03:00:00', 500, 'AVAILABLE'),(7, 5, '2017-02-20 03:00:00', 500, 'AVAILABLE'),
            (8, 3, '2017-03-20 03:00:00', 450, 'AVAILABLE');

-- Display subjectwise information on number of books purchased.
SELECT s.id AS ' Subject Id', s.name AS 'Subject Name', count(b.title_id) AS 'Number  Of Books Purchased' 
    FROM subjects s 
    JOIN books b 
    JOIN titles t ON t.id = b.title_id 
    WHERE s.id = t.subject_id 
    GROUP BY t.subject_id; 

-- Display those rows from books issue table where book can be returned after 2 months.That is, the difference in due date and issue date is greater than two months
SELECT accession_no AS 'Accession No', member_id AS 'Member Id', issue_date AS 'Issue Date', due_date AS 'Due Date' 
    FROM book_issue 
    WHERE TIMESTAMPDIFF(MONTH,issue_date,due_date) > 2 
    ORDER BY accession_no;  

-- SELECT command to display list of books having price greater than minimum price of books purchased so far.
SELECT accession_no AS 'Accession No',name AS 'Title', price 
    FROM books 
    JOIN titles ON id = title_id 
    WHERE price > (SELECT MIN(price) FROM books);