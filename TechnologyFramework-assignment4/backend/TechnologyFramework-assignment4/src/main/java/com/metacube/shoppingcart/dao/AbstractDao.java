package com.metacube.shoppingcart.dao;

import java.io.Serializable;

/**
 * This is a interface of abstract Dao classes .
 */
public interface AbstractDao<T, ID extends Serializable> {

	/**
	 * Find one product by id.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return the product
	 */
	T findOne(ID primaryKey);

	/**
	 * Find product by name.
	 *
	 * @param name
	 *            the product name
	 * @return the product
	 */
	Iterable<T> findByName(String name);

	/**
	 * Find all products.
	 *
	 * @return the iterable object
	 */
	Iterable<T> findAll();

}
