package com.metacube.shoppingCart;

import com.metacube.shoppingCart.view.DisplayInput;
/**
 *Create application which was explained in today's session.
 *
 *A product entity, dao and its facade layer.
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
