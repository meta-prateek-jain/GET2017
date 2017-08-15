package com.metacube.shoppingCart.test;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.*;

import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.facade.CartFacade;

public class ApplicationTest {
	private CartFacade shoppingCart;
	 @Before()
	    public void setupProduct() throws IOException{
	        shoppingCart=CartFacade.getInstance();
	    }
	 /**
	  * Test case to add product with valid id
	  */
	 @Test
	 public void addProductwithValidID(){
		 Status returnStatus = shoppingCart.addProductToCart(9, 3);
		 assertEquals(Status.ADDED, returnStatus);
	 }
	 /**
	  * Test case to add product with invalid id
	  */
	 @Test
	 public void addProductwithInValidID(){
		 Status returnStatus = shoppingCart.addProductToCart(2, 3);
		 assertNotEquals(Status.ADDED, returnStatus);
	 }
	/**
	 * Test case to check order removal with valid order id 
	 */
	 @Test
	 public void removeOrderwithValidId(){
		 shoppingCart.addProductToCart(5, 3);
		 Status returnStatus = shoppingCart.removeOrderFromCartByProductId(5);
		 assertEquals(Status.REMOVED, returnStatus);
	 }
	 /**
	 * Test case to check order removal with INvalid order id 
	 */
	 @Test
	 public void removeOrderwithInValidId(){
		 shoppingCart.addProductToCart(5, 3);
		 Status returnStatus = shoppingCart.removeOrderFromCartByProductId(3);
		 assertNotEquals(Status.REMOVED, returnStatus);
	 }
	 /**
	 * Test case to check order edit with valid order id 
	 */
	 @Test
	 public void editOrderwithValidId(){
		 shoppingCart.addProductToCart(5, 3);
		 Status returnStatus = shoppingCart.editCartProduct(5, 6);
		 assertEquals(Status.UPDATED, returnStatus);
	 }
	 /**
	 * Test case to check order edit with Invalid order id 
	 */
	 @Test
	 public void editOrderwithInValidId(){
		 shoppingCart.addProductToCart(5, 4);
		 Status returnStatus = shoppingCart.editCartProduct(3, 6);
		 assertNotEquals(Status.UPDATED, returnStatus);
	 }
}
