package com.metacube.shoppingCart.facade;

import java.io.IOException;
import java.util.Map;

import com.metacube.shoppingCart.dao.BaseDao;
import com.metacube.shoppingCart.dao.DaoFactory;
import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.Entity;
import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.model.BaseEntity;
import com.metacube.shoppingCart.model.Product;

/**
 * This facade class is used to perform business logic over products details
 * 
 * @author Prateek Jain
 *
 */
public class ProductFacade {
	private BaseDao<?> productList;
	private Status status;
	private Product product ;
	private static ProductFacade productFacade;
	private static int count =1;
	/**
	 * function is making class a singleton
	 * @return
	 * @throws IOException
	 */
	public static ProductFacade getInstance() throws IOException {
		//if productFacade is null then initialize 
		if (productFacade == null) {
			//synchronized it and double check condition of null
			synchronized (ProductFacade.class) {
				if (productFacade == null) {
					productFacade = new ProductFacade();
				}
			}
		}
		return productFacade;
	}
	
	/**
	 * Constructor to initialize the productList
	 * @throws IOException
	 */
	public ProductFacade() throws IOException{
		productList = DaoFactory.getDaoForEntity(Entity.PRODUCT, DBType.IN_MEMORY);
	}
	/**
	 * Function to check is product list is empty or not
	 * @return
	 */
	public Status isListEmpty() {
		status = Status.EMPTY;
		//if list is not empty then return status Not Empty
		if (productList.getList().size() > 0) {
			status = Status.NOT_EMPTY;
		}
		return status;
	}
	/**
	 * function to check if productId is Present or not
	 * @param productId
	 * @return
	 */
	public Status isProductPresent(String productName, String productType){
		status = Status.NOT_PRESENT;
		//loop till end of /map
		for(Map.Entry<Integer, BaseEntity> entry : productList.getList().entrySet()){
			product = (Product) entry.getValue();
			//if product is Present then return status Present
			if(product.getName().equalsIgnoreCase(productName) && product.getType().equalsIgnoreCase(productType)){
				status = Status.PRESENT;
			}
		}
		return status;
	}
	/**
	 * function to check if productId is Present or not
	 * @param productId
	 * @return
	 */
	public Status isProductIdPresent(int productId){
		status = Status.NOT_PRESENT;
		//if id is Present then return status Present
		if(productList.getList().containsKey(productId)){
			status = Status.PRESENT;
		}
		return status;
	}
	/**
	 * Function is used to add the product to list
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @return
	 */
	public Status addProductToList(int productId, String productName, String productType, int productPrice) {
		status = Status.FAILED;
		//check if product id is not present then add the product
		if(isProductIdPresent(productId)==Status.NOT_PRESENT){
			String[] details = {String.valueOf(productId),productName,productType, String.valueOf(productPrice)}; 
			product = new Product(details);
			productList.add(product);
			status = Status.ADDED;
		}
		return status;
	}
	/**
	 * Function to edit product present in product List
	 * @param productId
	 * @param price
	 * @return
	 */
	public Status editProduct(int productId, int price) {
		status = Status.FAILED;
		//if list is not empty and product is present then edit it and return status Updated 
		if(isListEmpty()==Status.NOT_EMPTY && isProductIdPresent(productId)==Status.PRESENT){
			productList.edit(productId, price);
			status = Status.UPDATED;
		}
		return status;
	}
	/**
	 * Function is used to remove the product from the list
	 * 
	 * @param productId
	 * @return
	 */
	public Status removeProductFromListByProductId(int productId) {
		status = Status.FAILED;
		//if list is not empty and product is present then remove the product
		if(isListEmpty()==Status.NOT_EMPTY && isProductIdPresent(productId)==Status.PRESENT){
			productList.remove(productId);
			status = Status.REMOVED;
		}
		return status;
	}
	/**
	 * Function to generate the product id
	 * 
	 * @return
	 */
	public int generateUniqueProductId(){
		count++;
        if(isProductIdPresent(count)==Status.PRESENT){
            count = generateUniqueProductId();
        }
        return count;

	}
	/**
	 * Function to retrieve the product from list by its id
	 * @param productId
	 * @return
	 */
	public Product retrieveProductFromListById(int productId) {
		//if list is not empty and product is present then return the product
		if(isListEmpty()==Status.NOT_EMPTY && isProductIdPresent(productId)==Status.PRESENT){
			product = (Product) productList.retrieve(productId);
		}
		return product;
	}
	/**
	 * toString function is override to display the product list
	 */
	@Override
	public String toString() {
		String productDetails;
		/*
		 * if list is empty then display the message
		 * else display the products details 
		 */
		if (isListEmpty() == Status.EMPTY) {
			productDetails = "\nNo Product is Present in Store\n";
		}else{
			productDetails = "\nProducts in Store\n\n";
			for (Map.Entry<Integer, BaseEntity> entry : productList.getList().entrySet()) {
				product = (Product) entry.getValue();
				productDetails += product.getId()
						+ "  -->  "
						+ product.getName()
						+ "  -->  "
						+ product.getType()
						+ "  -->  Price :  Rs "
						+ product.getPrice()
						+"\n";
			}
		}
		return productDetails;
	}
}
