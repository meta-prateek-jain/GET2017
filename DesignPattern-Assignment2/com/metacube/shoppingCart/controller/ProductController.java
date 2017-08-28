package com.metacube.shoppingCart.controller;

import java.io.IOException;

import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.view.DisplayOutput;

/**
 * Controller class used to control the flow of data between view and dao
 * 
 * @author Prateek Jain
 *
 */
public class ProductController {
	private Status status;
	private ProductFacade productFacade;
	private static ProductController productController;

	/**
	 * Making Class to be singleton
	 * 
	 * @return 
	 */
	public static ProductController getInstance() {
		//if productController is null then initialize it 
		if (productController == null) {
			//synchronize and double checking for multi threading environment
			synchronized (ProductController.class) {
				if (productController == null) {
					productController = new ProductController();
				}
			}
		}

		return productController;
	}
	/**
	 * Constructor to initialize the facade objects;
	 */
	public ProductController() {
		try {
			productFacade = ProductFacade.getInstance();
		} catch (IOException e) {
			new DisplayOutput("Error in Reading File.Halting the application");
			System.exit(0);
		}
	}
	/**
	 * Function is used to check Product is present or not
	 * @param name
	 * @param type
	 * @return
	 */
	public Status checkProduct(String name, String type) {
		return productFacade.isProductPresent(name, type);
	}
	/**
	 * Function is used to generate unique id
	 * @return
	 */
	public int generateId() {
		return productFacade.generateUniqueProductId();
	}
	/**
	 * Function to check list is empty or not
	 * @return
	 */
	public Status checkList(){
		return productFacade.isListEmpty();
	}
	/**
	 * Function to check product id is empty or not
	 * @return
	 */
	public Status checkProductId(int productId){
		return productFacade.isProductIdPresent(productId);
	}
	
	/**
	 * Function is used to add Product to list
	 * @param id
	 * @param name
	 * @param Type
	 * @param price
	 */
	public void addProductInList(int id, String name, String Type, int price){
		status=productFacade.addProductToList(id, name, Type, price);
		new DisplayOutput(status.toString());
		if(status==Status.ADDED){
			new DisplayOutput(productFacade.retrieveProductFromListById(id).toString());
		}
	}
	/**
	 * Function is used to display the product list. 
	 */
	public void displayProductList() {
		new DisplayOutput(productFacade.toString());
	}
	public void editCart(int id, int price) {
		status = productFacade.editProduct(id, price);
		new DisplayOutput(status.toString());
		if(status==Status.UPDATED){
			new DisplayOutput(productFacade.retrieveProductFromListById(id).toString());
		}
	}
	public void removeProduct(int id) {
		status = productFacade.removeProductFromListByProductId(id);
		new DisplayOutput(status.toString());
	}

}
