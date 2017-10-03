package com.metacube.shoppingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is used to create connection with database.
 */
public class JdbcConnectionFactory {
	Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "root", "1234");
			return connection;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}
