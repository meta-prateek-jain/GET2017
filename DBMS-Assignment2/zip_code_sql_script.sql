-- Creating the database
CREATE DATABASE IF NOT EXISTS form;

-- using the database
USE form;

-- creating required tables
CREATE TABLE IF NOT EXISTS states (
     name VARCHAR(100) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS cities (
    name VARCHAR(100) PRIMARY KEY
);
    
CREATE TABLE IF NOT EXISTS zip_code (
    code INT NOT NULL PRIMARY KEY,
    state_name VARCHAR(100),
    city_name VARCHAR(100),
    CONSTRAINT fk_state_name FOREIGN KEY(state_name) REFERENCES states(name) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_city_name FOREIGN KEY(city_name) REFERENCES cities(name) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserting the sample data
INSERT INTO states(name) VALUES ('RAJASTHAN'),('ANDHRA PRADESH'),('ASSAM'),('BIHAR');
INSERT INTO cities(name) VALUES ('Banswara'),('Dungarpur'),('Jaipur'),('Godavari'),('Nellore'),('Nagaon'),('Diphu'),('Patna'),('Gaya');
INSERT INTO zip_code(code,city_name,state_name) VALUES (327001,'Banswara','RAJASTHAN'),(314001,'Dungarpur','RAJASTHAN'),(302016,'Jaipur','RAJASTHAN'),(533260,'Dungarpur','ANDHRA PRADESH'),(524414,'Nellore','ANDHRA PRADESH'),(782001,'Nagaon','ASSAM'),(782447,'Diphu','ASSAM'),(804453,'Patna','BIHAR'),(804428,'Gaya','BIHAR');

-- SELECT command to display Zip Code, City Names and States ordered by State Name and City Name.
SELECT code AS 'ZIP CODE',city_name AS 'CITY NAMES', state_name AS 'STATES' FROM zip_code ORDER BY state_name,city_name;

-- SELECT command to display Zip Code, City Names and States ordered by State Name and City Name for particular zip-code.
SELECT code AS 'ZIP CODE',city_name AS 'CITY NAMES', state_name AS 'STATES' FROM zip_code WHERE code = 327001 ORDER BY state_name,city_name;