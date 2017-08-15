package com.metacube.shoppingCart.controller;

import java.io.IOException;
import com.metacube.shoppingCart.facade.BillGeneratorFacade;
import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.facade.CartFacade;
import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.view.DisplayOutput;

/**
 * Controller class used to control the flow of data between view and dao
 * 
 * @author Prateek Jain
 *
 */
public class CartController {
	private Status status;
	private CartFacade cartFacade;
	private ProductFacade productFacade;
	private BillGeneratorFacade billGeneratorFacade;
	private static CartController cartController;

	/**
	 * Making Class to be singleton
	 * 
	 * @return 
	 */
	public static CartController getInstance() {
		//if cartController is null then initialize it 
		if (cartController == null) {
			//synchronize and double checking for multi threading environment
			synchronized (CartController.class) {
				if (cartController == null) {
					cartController = new CartController();
				}
			}
		}

		return cartController;
	}

	/**
	 * Constructor to initialize the facade objects;
	 */
	public CartController() {
		try {
			cartFacade = CartFacade.getInstance();
			productFacade = ProductFacade.getInstance();
			billGeneratorFacade = BillGeneratorFacade.getInstance();
		} catch (IOException e) {
			new DisplayOutput("Error in Reading File.Halting the application");
			System.exit(0);
		}
	}

	/**
	 * Function is called when user wants to buy product and add the product to cart
	 *   
	 * @param id
	 * @param quantity
	 */
	public void buyProduct(int id, int quantity) {
		status = cartFacade.addProductToCart(id, quantity);
		new DisplayOutput(status.toString());
		if(status==Status.ADDED || status==Status.UPDATED){
			new DisplayOutput(cartFacade.retrieveOrderFromCartById(id).toString());
		}
	}
	
	/**
	 * Function is used to check if id is valid or not
	 * @param id
	 * @return
	 */
	public Status checkIdValidity(int id){
		return cartFacade.isProductIdValid(id);
	}
	
	/**
	 * Function is used to check if cart is empty or not
	 * @return
	 */
	public Status checkCartSize(){
		return cartFacade.isCartEmpty();
	}
	
	/**
	 * Function is used to check if product with this id is present in cart or not
	 * 
	 * @param id
	 * @return
	 */
	public Status checkIdPresentInCart(int id){
		return cartFacade.isProductPresentInCart(id);
	}
	
	/**
	 * Function is used to display the cart
	 */
	public void displayCart(){
		new DisplayOutput(cartFacade.toString());
	}

	/**
	 * Function is used to edit the cart 
	 * @param id
	 * @param quantity
	 */
	public void editCart(int id, int quantity) {
		status = cartFacade.editCartProduct(id, quantity);
		new DisplayOutput(status.toString());
		if(status==Status.UPDATED){
			new DisplayOutput(cartFacade.retrieveOrderFromCartById(id).toString());
		}
	}
	
	/**
	 * Function is used to remove order from cart
	 *  
	 * @param id
	 */
	public void removeOrderFromCart(int id) {
		status = cartFacade.removeOrderFromCartByProductId(id);
		new DisplayOutput(status.toString());
	}

	/**
	 * Function is used to display the product list. 
	 */
	public void displayProductList() {
		new DisplayOutput(productFacade.toString());
	}

	/**
	 * Function is used to generate the bill on checkout
	 */
	public void generateBill() {
		try {
			new DisplayOutput(billGeneratorFacade.display());
		} catch (IOException e) {
			new DisplayOutput("Error in generating Bill. Halting the application");
			System.exit(0);
		}
	}
}
