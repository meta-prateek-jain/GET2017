package com.metacube.shoppingCart;

import com.metacube.shoppingCart.view.DisplayInput;
/**
 *This application will be a shopping cart application which will have following functionality.
 *Application will have products which should contain at least these attributes:
 *Product Code
 *Type
 *Name
 *Price
 *A User should able to add products in the cart.
 *Cart should be editable. Also product quantity should be editable.
 *At last user should able to see his cart.
 *
 * @author Prateek Jain
 * Dated : 12/08/2017
 *
 */
public class Main {
	public static void main(String[] args) {
		//calling display input function to take inputs from user 
		DisplayInput.getInstance().displayInput();
	}
}
