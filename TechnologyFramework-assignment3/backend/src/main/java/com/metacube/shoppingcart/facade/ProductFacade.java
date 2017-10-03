package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * Product Facade layer class contains all the business logic of the project
 */
public interface ProductFacade {
	List<ProductDto> getAllProducts();

	ProductDto getProductById(int id);

	Status addProduct(Product entity);

	Status deleteProductById(int id);

	Status editProduct(Product entity, int id);

	List<ProductDto> getProductByName(String name);
}
