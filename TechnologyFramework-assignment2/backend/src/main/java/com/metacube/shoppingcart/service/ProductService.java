package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * Product service is an inheritance class
 */
public interface ProductService {
	Iterable<Product> getAllProducts();

	Product getProductById(int id);

	Status addProduct(Product entity);

	Status deleteProductById(int id);

	Status editProduct(Product entity, int id);

	Iterable<Product> getProductByName(String name);
}
