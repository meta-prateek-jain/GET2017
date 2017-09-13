package com.metacube.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class is used to establish the connection with database
 * 
 * @author Prateek Jain
 *
 */
public class MySQlConnection {
	/**
	 * Method is used to establish the connection
	 * 
	 * @return
	 * 		established connection with database
	 */
	public static Connection establish() {
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String mysqlURL = "jdbc:mysql://localhost:3306/"+Constants.dbName;
			connection = DriverManager.getConnection(mysqlURL,Constants.userId, Constants.password);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loaing Driver: "+cnfe);
		} catch (SQLException sqle) {
			System.out.println("Error in creating the connection");
		}
		return connection;
	}
}
