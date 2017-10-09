CREATE database shopping_cart;
CREATE USER 'cart_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON shopping_cart.* TO 'cart_user'@'localhost';

use shopping_cart;

CREATE TABLE Product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  price DOUBLE UNSIGNED
);

INSERT INTO Product VALUES
( 1, 'Badminton', 450),
( 2, 'Football', 650),
( 3, 'Cricket Set', 5900),
( 4, 'Basket Ball', 840),
( 5, 'Volley Ball', 470),
( 6, 'Watch', 12000),
( 7, 'shoes', 1500),
( 8, 'Treadmill', 3500),
( 9, 'Sports Cycle', 6800),
( 10, 'Boxing gloves', 980),
( 11, 'Chess', 1400),
( 12, 'Table Tennis set', 1896),
( 13, 'Baseball Bat', 874),
( 14, 'Dumbbells', 638),
( 15, 'Badminton Net', 460),
( 16, 'Cricket Ball', 150);