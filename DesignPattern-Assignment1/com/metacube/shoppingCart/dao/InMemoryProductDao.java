package com.metacube.shoppingCart.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.shoppingCart.model.BaseEntity;
import com.metacube.shoppingCart.model.Product;
import com.metacube.shoppingCart.util.Constants;
import com.metacube.shoppingCart.util.FileHandling;

/**
 * Class is used to add, update, retrieve and remove data from file;
 * 
 * @author Prateek Jain
 *
 */
public class InMemoryProductDao implements ProductDao {
	private static InMemoryProductDao productDao;
	private static Map<Integer, BaseEntity> productMap = new HashMap<Integer, BaseEntity>();

	// constructor call function to initialize the productlist;
	public InMemoryProductDao() throws IOException {
		initProductList();
	}

	/**
	 * Function to get singleton instance
	 * 
	 * @return
	 * @throws IOException
	 */
	public static InMemoryProductDao getInstance() throws IOException {
		// if prductDao is not null then initialize it else return the productDao
		if (productDao == null) {
			productDao = new InMemoryProductDao();
		}
		return productDao;
	}

	/**
	 * Initialize the product Map
	 * 
	 * @throws IOException
	 */
	public void initProductList() throws IOException {
		List<String> productsDetails = new FileHandling().read(Constants.PRODUCT_LIST_PATH);
		// loop continue till end of productsDetails
		for (String str : productsDetails) {
			String[] details = str.split(",");
			//if product has all details then add it to productList map
			if(details.length>=4){
				productMap.put(Integer.parseInt(details[0]), new Product(details));
			}
		}
	}

	/**
	 * Function to add product to product Map
	 */
	public void add(BaseEntity productEntity) {
		productMap.put(productEntity.getId(), productEntity);
	}

	/**
	 * function to edit product price.
	 */
	public void edit(int id, int price) {
		((Product) productMap.get(id)).setPrice(price);
	}

	/**
	 * function to retrieve particular product by its id
	 */
	public Product retrieve(int id) {
		return (Product) productMap.get(id);
	}

	/**
	 * function to remove particular product by its id
	 */
	public void remove(int id) {
		productMap.remove(id);
	}

	/**
	 * function to return the map of product.
	 */
	public Map<Integer, BaseEntity> getList() {
		return productMap;
	}
}
