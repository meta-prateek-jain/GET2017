package com.metacube.shoppingcart.dao.product;

import com.metacube.shoppingcart.dao.AbstractDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * Product Dao interface
 */
public interface ProductDao extends AbstractDao<Product, Integer> {

	/**
	 * Method is used to save the product
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	<S extends Product> Status saveOrUpdateProduct(S entity);

	
	/**
	 * Delete the product by id.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return the status
	 */
	Status deleteProductById(Integer primaryKey);

}
