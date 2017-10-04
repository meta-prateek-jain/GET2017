package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * This is a abstract class to perform general project operations
 * 
 * @author Prateek Jain
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T, ID> {

	protected abstract String getTableName();
	protected abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * Method is used to save the new product to list
	 */
	public <S extends T> Status save(S entity) {
		Status result = Status.SUCCESS;
		Product product = (Product) entity;
		try {
			Statement stmt = createdStatement();
			String query = "INSERT INTO " + getTableName() + " (name,price)"
					+ " VALUES ('" + product.getName() + "','"
					+ product.getPrice() + "');";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.ERROR_OCCURED;
		}
		return result;
	}

	/**
	 * Method is used to find product by id
	 */
	public T findOne(final ID primaryKey) {
		T result = null;
		try {
			Statement stmt = createdStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " WHERE " + getPrimaryKeyColoumnName()
					+ " = '" + primaryKey + "'");
			// loop continue till end of resultSet is reached
			while (resultSet.next()) {
				result = extractResultSetRow(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Method is used to find the products list by filtering the list by name 
	 */
	public Iterable<T> findByName(final String name) {
		try {
			Statement stmt = createdStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " WHERE name LIKE '%" + name + "%';");
			List<T> productList = new ArrayList<>();
			// loop continue till end of resultSet is reached
			while (resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Method is used to return list of products available
	 */
	public Iterable<T> findAll() {
		try {
			Statement stmt = createdStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "+ getTableName());
			List<T> productList = new ArrayList<>();
			// loop continue till end of resultSet is reached
			while (resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	/**
	 * Method is used to get the created statement object 
	 * @return
	 * 			the created statement
	 * @throws Exception
	 * @throws SQLException
	 */
	private Statement createdStatement() throws Exception, SQLException {
		return JdbcConnectionFactory.getConnection().createStatement();
	}

}
