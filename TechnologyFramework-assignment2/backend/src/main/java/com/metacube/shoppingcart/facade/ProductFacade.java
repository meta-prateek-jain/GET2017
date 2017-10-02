package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * Product Facade layer class contains all the business logic of the project
 */
public interface ProductFacade {
	Iterable<ProductDto> getAllProducts();

	ProductDto getProductById(int id);

	Status addProduct(Product entity);

	Status deleteProductById(int id);

	Status editProduct(Product entity, int id);

	Iterable<ProductDto> getProductByName(String name);
}
