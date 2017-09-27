package com.metacube.get.layarch.service;

import com.metacube.get.layarch.model.Product;

/**
 * Product service is an inheritance class
 */
public interface ProductService
{
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
}
