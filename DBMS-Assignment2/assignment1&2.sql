/* SELECT command to display all columns of members table*/
SELECT * FROM members;

/*SELECT command to display member_nm, member_id and category columns of members table*/
SELECT id, name, category FROM members;

/*SELCET command to display member_nm, member_id and category columns of members table where category of member is F*/
SELECT id, name, category FROM members WHERE category = 'F';

/*SELECT command to display various categories of members*/
SELECT DISTINCT(category) FROM members;

/*SELECT command to display member name and their categories in the descending order of member name*/
SELECT name, category FROM members ORDER BY name DESC;

/*SELECT command to display all the titles and their subjects and publishers*/
SELECT titles.name AS 'Title',subjects.name AS 'Subject', publishers.name AS 'Publisher' 
    FROM titles 
    INNER JOIN subjects ON subjects.id = titles.subject_id 
    INNER JOIN publishers ON publishers.id = titles.publisher_id ;

/*SELECT command to display number of members present in each category. The result should include category and number of members belonging to that category*/
SELECT category, COUNT(1) AS 'Number Of Members' FROM members GROUP BY category;

/*SELECT command to display name of those members who belong to category as to which member "keshav sharma" belongs*/
SELECT member1.name 
    FROM members member1 
    INNER JOIN members member2  ON LOWER(member2.name) = LOWER('Keshav Sharma') AND member1.category = member2.category;

/*SELECT command to display information on all the books issued.
The result shoul include issue date, accession no, member id and return date. 
If the book has not returned, the coulmn return date should be left blank.*/
SELECT bissue.issue_date "Issue Date", bissue.accession_no "Accession No.", bissue.member_id "Memeber Id", breturn.return_date "Return Date" 
    FROM book_issue bissue 
    LEFT JOIN book_return breturn USING(member_id, accession_no);

/*SELECT command to display above command results in ascending order of issue date and within issue date in ascending order of member's name*/
SELECT bissue.issue_date "Issue Date", bissue.accession_no "Accession No.", bissue.member_id "Memeber Id", breturn.return_date "Return Date" 
    FROM book_issue bissue 
    LEFT JOIN book_return breturn USING(member_id, accession_no) 
    INNER JOIN members ON bissue.member_id = members.id
    ORDER BY bissue.issue_date, members.name;