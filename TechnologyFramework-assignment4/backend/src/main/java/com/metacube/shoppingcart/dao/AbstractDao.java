package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;

/**
 * This is a interface of abstract Dao classes .
 */
public interface AbstractDao<T, ID extends Serializable> {

	/**
	 * Method is used to save the product
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	<S extends T> Status save(S entity);

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
