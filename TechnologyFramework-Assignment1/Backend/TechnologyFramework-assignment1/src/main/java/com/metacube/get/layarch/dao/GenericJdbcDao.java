package com.metacube.get.layarch.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a abstract class to perform general project
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID>
{
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();
	protected abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * Method is used to save the new product to list
	 */
	public <S extends T> S save(final S entity)
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeQuery("Insert INTO " + getTableName() + " VALUES(" + entity + ");");
		} catch (Exception e) {
			System.out.println("error");
		}
		
		return null;
	}

	/**
	 * Method is used to fing product by id
	 */
	public T findOne(final ID primaryKey)
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			//TODO - Logging
			return null;
		}
	}

	/**
	 * Method is used to return list of products available
	 */
	public Iterable<T> findAll ()
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> userList = new ArrayList<>();
			while(resultSet.next()) {
				userList.add(extractResultSetRow(resultSet));
			}
			return userList;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}

	}
}
