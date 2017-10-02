package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * Describe the service class to get products
 */
public class DefaultProductService implements ProductService {
	ProductDao productDao;
	
	/**
	 * This is used to initialize the productDao object
	 * @param productDao
	 */
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * This is used to get all the products list
	 */
	@Override
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	/**
	 * Method is used to get the product by id
	 */
	@Override
	public Product getProductById(final int id) {
		return productDao.findOne(id);
	}

	/**
	 * Method is used to add product to list
	 */
	@Override
	public Status addProduct(Product product) {
		return productDao.save(product);
	}

	/**
	 * Method is used to delete the product
	 */
	@Override
	public Status deleteProductById(int id) {
		return productDao.deleteById(id);
	}

	/**
	 * Method is used to edit the product
	 */
	@Override
	public Status editProduct(Product product, int id) {
		return productDao.edit(product, id);
	}

	/**
	 * Method is used to get the list of products after filtering the list
	 */
	@Override
	public Iterable<Product> getProductByName(String name) {
		return productDao.findByName(name);
	}
}
