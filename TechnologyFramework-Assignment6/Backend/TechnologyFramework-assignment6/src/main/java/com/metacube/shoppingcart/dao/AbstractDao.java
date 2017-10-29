package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.model.Order;

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
	T getOne(String id);

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
	
	/**
	 * Save the order
	 * @param id
	 * 		Id the of the person
	 * @param order
	 * 		order to save
	 * @return
	 * 		ID of operation
	 */
	int saveOrder(String id, Order order);
	/**
	 * deleet them
	 * 
	 * @param primaryKey
	 * 			
	 * @return
	 */
	boolean delete(ID primaryKey);
}
