-- Selecting the database
USE library_information_system;

/* SELECT command to display name of those members
who belong to the category as to which member “Keshav Sharma” belongs.
Note: Solve the problem using subquery.*/
SELECT name AS 'Member name' 
    FROM members 
    WHERE category = (SELECT category 
                        FROM members member WHERE LOWER(member.name) = LOWER('Keshav Sharma'));

/* SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
Note: Use Correlated Subquery. */
SELECT issue_date,titles.name AS 'Title',members.name AS 'Member name', due_date AS 'Due date'
    FROM book_issue bi 
    JOIN members ON bi.member_id = members.id
    JOIN titles ON titles.id = (SELECT title_id FROM books WHERE bi.accession_no = books.accession_no) 
    WHERE NOT EXISTS (SELECT br.accession_no, br.member_id 
                        FROM book_return br
                        WHERE br.member_id = bi.member_id AND br.accession_no = bi.accession_no); 

/*SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due date.
Note: Use Correlated Subquery.
*/
SELECT bi.issue_date,titles.name AS 'Title',members.name AS 'Member name', due_date 
    FROM book_issue bi 
    JOIN members ON bi.member_id = members.id
    JOIN titles ON titles.id = (SELECT books.title_id FROM books WHERE books.accession_no = bi.accession_no)  
    WHERE EXISTS (SELECT br.accession_no, br.member_id 
                    FROM book_return br 
                    WHERE br.return_date > bi.due_date AND bi.member_id = br.member_id AND bi.accession_no = br.accession_no); 

/*SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far.*/
SELECT books.accession_no, titles.name AS 'Title', books.purchase_date, books.price 
    FROM books 
    JOIN titles ON title_id = titles.id
    WHERE books.price = (SELECT MAX(price) FROM books);

-- SELECT command to display the second maximum price of a book.
SELECT books.accession_no, titles.name AS 'Title', purchase_date, price 
    FROM books 
    JOIN titles ON books.title_id = titles.id
    GROUP BY books.price 
    ORDER BY books.price DESC 
    LIMIT 1 offset 1;
