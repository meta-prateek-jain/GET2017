package com.metacube.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.dao.JdbcConnectionFactory;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * This is product dao to extract the data from products list available in database table by executing a query
 */
@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao {
	private String tableName = "Product";

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
	
	/**
	 * Method is used to delete the product by id
	 */
	public Status deleteProductById(Integer primaryKey) {
		Status result = Status.SUCCESS;
		try {
			Statement stmt = createdStatement();
			String query = "DELETE FROM " + getTableName() + " WHERE "
					+ getPrimaryKeyColoumnName() + " = '" + primaryKey + "'";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.ERROR_OCCURED;
		}
		return result;
	}

	/**
	 * Method is used to Edit the detail of a product
	 * 
	 * @param product
	 *            		product to edit
	 * @param primaryKey
	 *            		primary key of table
	 * @return 			status of operation
	 */
	public Status editProduct(Product product, Integer primaryKey) {
		Status result = Status.SUCCESS;
		try {
			Statement stmt = createdStatement();
			String query = "UPDATE " + getTableName() + " SET name = '"
					+ product.getName() + "' , price = " + product.getPrice()
					+ " WHERE " + getPrimaryKeyColoumnName() + " = "
					+ primaryKey + " ;";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.ERROR_OCCURED;
		}
		return result;
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
