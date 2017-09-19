/*Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.*/
CREATE VIEW member_details
    AS SELECT members.name AS 'Member name', bi.issue_date AS 'Issue date', bi.due_date AS 'Due date' 
        FROM members
        JOIN book_issue bi ON members.id = bi.member_id;

-- SELECT command to display member name and all issue details of the member
SELECT * FROM member_details;

/* Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O. */
CREATE VIEW member_description
    AS SELECT id AS 'Member id', name AS 'Member name',  
    CASE LOWER(category)
      WHEN 'f' THEN 'Faculty'
      WHEN 's' THEN 'Student'
      ELSE 'Others'
    END  AS 'Category'
    FROM members;

-- SELECT command to display all details of the member
SELECT * FROM member_description;


/*Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.*/
DROP VIEW book_details;
CREATE VIEW book_details
    AS SELECT subjects.name AS 'Subject name',titles.name AS 'Title', members.name AS 'Member name',
    CASE LOWER(category)
      WHEN 'f' THEN 'Faculty'
      WHEN 's' THEN 'Student'
      ELSE 'Others'
    END  AS 'Category',
    bi.issue_date AS 'Issue date',
    bi.due_date AS 'Due date',
    br.return_date AS 'Return date'
    FROM book_issue bi 
    LEFT JOIN book_return br USING(member_id,accession_no)
    JOIN members ON bi.member_id = members.id
    JOIN titles
    JOIN subjects
    WHERE titles.id = (SELECT title_id FROM books WHERE books.accession_no = bi.accession_no)
          AND subjects.id = titles.subject_id;
       
-- SELECT command to display all details of book including issue details
SELECT * FROM book_details ORDER BY `Return date`;