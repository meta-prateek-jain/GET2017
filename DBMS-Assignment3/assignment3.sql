-- SELECT command to display total Number of students,total number of faculty and total number of others in library information system in a single row.
SELECT COUNT(IF(category IN ('S'), 1, NULL)) AS 'Total Number Of Students', 
       COUNT(IF(category IN ('F'), 1, NULL)) AS 'Total Number Of Faculty' ,
       COUNT(IF(category NOT IN ('F','S'), 1, NULL)) AS 'Total Number Of Others' 
    FROM members;

-- SELECT command to display the information of those titles that have been issued more than 2 time.
SELECT t.id, t.name AS 'Title Name' 
    FROM titles t
    JOIN books b ON t.id = b.title_id
    JOIN book_issue bi ON bi.accession_no = b.accession_no
    GROUP BY bi.accession_no
    HAVING COUNT(bi.accession_NO) > 2;

-- SELECT command to display information on books issued to members of category other than "F" (Faculty)
SELECT Distinct(b.accession_no), t.name AS 'Title', b.price 
    FROM books b
    JOIN titles t ON t.id = title_id 
    JOIN book_issue USING (accession_no)
    JOIN members m ON m.id = member_id 
    WHERE m.category NOT IN ('F');

-- SELECT command to display information on those authors for which atleast one book has been purchased
SELECT DISTINCT(a.id), a.name AS 'Author Name' 
    FROM authors a 
    JOIN title_author ta ON ta.author_id = a.id 
    JOIN books b on ta.title_id = b.title_id;
    
