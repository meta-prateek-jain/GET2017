package com.metacube.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.model.Product;

/**
 * This is product dao to extract the data from products list
 */
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao {
	private String tableName;

	/**
	 * Method is used to set the table name
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Override the method to get name
	 */
	@Override
	protected String getTableName() {
		return tableName;
	}
	
	/**
	 * Method is used to extract Result set rows by applying filter
	 */
	@Override
	protected Product extractResultSetRow(final ResultSet resultSet) {
		Product product = new Product();
		try {
			product.setPrice(resultSet.getDouble("price"));
			product.setName(resultSet.getString("name"));
			product.setId(resultSet.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	/**
	 * Method is used to get primaryKey column name
	 */
	@Override
	protected String getPrimaryKeyColoumnName() {
		return "id";
	}
}
