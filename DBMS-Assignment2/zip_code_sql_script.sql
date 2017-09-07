-- Drop the database if exists
DROP DATABASE IF EXISTS form;

-- Creating the database
CREATE DATABASE form;

-- using the database
USE form;

-- creating required tables
CREATE TABLE states (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE city (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
    
CREATE TABLE zipcode_information (
    code INT PRIMARY KEY,
    state_id INT,
    city_id INT,
    CONSTRAINT fk_state_id FOREIGN KEY(state_id) REFERENCES states(id) ON DELETE CASCADE,
    CONSTRAINT fk_city_id FOREIGN KEY(city_id) REFERENCES city(id) ON DELETE CASCADE
);

-- Inserting the sample data
INSERT INTO states(name) VALUES ('RAJASTHAN'),('ANDHRA PRADESH'),('ASSAM'),('BIHAR');
INSERT INTO city(name) VALUES ('Banswara'),('Dungarpur'),('Jaipur'),('Godavari'),('Nellore'),('Nagaon'),('Diphu'),('Patna'),('Gaya');
INSERT INTO zipcode_information(code,city_id,state_id) VALUES (327001,1,1),(314001,2,1),(302016,3,1),(533260,4,2),(524414,5,2),(782001,6,3),(782447,7,3),(804453,8,4),(804428,9,4);

-- SELECT command to display Zip Code, City Names and States ordered by State Name and City Name.
SELECT code AS 'Zip code',c.name AS 'City', s.name AS 'State' 
FROM zipcode_information 
JOIN city c ON city_id = c.id 
JOIN states s ON state_id = s.id 
ORDER BY s.name,c.name;

-- SELECT command to display Zip Code, City Names and States ordered by State Name and City Name for particular zip-code.
SELECT code AS 'Zip code',c.name AS 'City', s.name AS 'State' 
FROM zipcode_information 
JOIN city c ON city_id = c.id 
JOIN states s ON state_id = s.id 
WHERE code = 327001;
