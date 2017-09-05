-- Creating the database
CREATE DATABASE IF NOT EXISTS ecommerse;

-- using the database
USE ecommerse;

-- creating the table;
CREATE TABLE IF NOT EXISTS categories(
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    parent_category VARCHAR(100),
    PRIMARY KEY (id, name)
);

-- Inserting the sample data 
INSERT INTO categories(name) VALUES ('Mobiles & Tablets'),('computers'),('Home Appliances');
INSERT INTO categories(name,parent_category) VALUES ('Mobiles','Mobiles & Tablets'),('Tablets','Mobiles & Tablets'),('Accessories','Mobiles & Tablets'),('Cases & covers','Mobiles & Tablets');
INSERT INTO categories(name,parent_category) VALUES ('Desktop','computers'),('Laptop','computers'),('Laptop Accessories','computers'),('Printers','computers');
INSERT INTO categories(name,parent_category) VALUES ('TVs','Home Appliances'),('Air Conditioners','Home Appliances'),('Washing Machine','Home Appliances');
INSERT INTO categories(name,parent_category) VALUES ('Smart Phones','Mobiles'),('Featured Phones','Mobiles');
INSERT INTO categories(name,parent_category) VALUES ('2G','Tablets'),('3G','Tablets');
INSERT INTO categories(name,parent_category) VALUES ('Mouse','Laptop Accessories'),('Keyboard','Laptop Accessories'),('Headphones','Laptop Accessories');
INSERT INTO categories(name,parent_category) VALUES ('Inkjet','Printers'),('Laser','Printers');
INSERT INTO categories(name,parent_category) VALUES ('LED','TVs'),('LCD','TVs'),('Plasma','TVs');
INSERT INTO categories(name,parent_category) VALUES ('Full Automatic','Washing Machine'),('Semi Automatic','Washing Machine');
INSERT INTO categories(name,parent_category) VALUES ('Top Load','Full Automatic'),('Front Load','Full Automatic');

-- Display all categories along with their parent category
SELECT id AS ID, name AS Name,parent_category AS 'Parent Category' FROM categories ;

-- Display all categories along with their parent category sorted by parent category
SELECT id AS ID, name AS Name,parent_category AS 'Parent Category' FROM categories ORDER BY parent_category ;

-- Display all categories along with their parent category sorted by parent category. If category is top category then it should display “Top Category” in Parent category. 
SELECT id AS ID, name AS Name,IFNULL(parent_category, 'Top Category')  AS 'Parent Category' FROM categories ORDER BY parent_category ;

-- display only Top Categories.
SELECT id AS ID, name AS Name,IFNULL(parent_category, 'Top Category')  AS 'Parent Category' FROM categories WHERE parent_category IS NULL;