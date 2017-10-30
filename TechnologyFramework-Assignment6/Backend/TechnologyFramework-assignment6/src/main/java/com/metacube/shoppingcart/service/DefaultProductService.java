package com.metacube.shoppingcart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * Describe the service class to get products
 */
@Service("productService")
@Transactional
public class DefaultProductService implements ProductService {
	@Resource(name = "hibernateProductDao")
	ProductDao productDao;
	
	public DefaultProductService() { }
	
	/**
	 * Gets the product dao.
	 *
	 * @return the product dao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * Sets the product dao.
	 *
	 * @param productDao
	 *            the new product dao
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
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
		return productDao.saveOrUpdateProduct(product);
	}

	/**
	 * Method is used to delete the product
	 */
	@Override
	public Status deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}

	/**
	 * Method is used to edit the product
	 */
	@Override
	public Status editProduct(Product product, int id) {
		return productDao.saveOrUpdateProduct(product); 
	}

	/**
	 * Method is used to get the list of products after filtering the list
	 */
	@Override
	public Iterable<Product> getProductByName(String name) {
		return productDao.findByName(name);
	}
}
