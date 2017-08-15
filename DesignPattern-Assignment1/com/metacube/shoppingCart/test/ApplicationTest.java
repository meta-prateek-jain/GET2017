package com.metacube.shoppingCart.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.facade.ProductFacade;

public class ApplicationTest {
	private ProductFacade productList;
	 @Before()
	    public void setupProduct() throws IOException{
	        productList=ProductFacade.getInstance();
	    }
	 /**
	  * Test case to add product with valid id
	  */
	 @Test
	 public void addProductwithValidID(){
		 Status returnStatus = productList.addProductToList(6, "puma", "loafer", 2000);
		 assertEquals(Status.ADDED, returnStatus);
	 }
	 /**
	  * Test case to add product with invalid id
	  */
	 @Test
	 public void addProductwithInValidID(){
		 Status returnStatus = productList.addProductToList(3,  "monte carlo", "loafer", 2000);
		 assertNotEquals(Status.ADDED, returnStatus);
	 }
	/**
	 * Test case to check order removal with valid order id 
	 */
	 @Test
	 public void removeProductwithValidId(){
		 productList.addProductToList(3, "puma", "loafer", 2000);
		 Status returnStatus = productList.removeProductFromListByProductId(3);
		 assertEquals(Status.REMOVED, returnStatus);
	 }
	 /**
	 * Test case to check order removal with INvalid order id 
	 */
	 @Test
	 public void removeOrderwithInValidId(){
		 productList.addProductToList(3, "puma", "loafer", 2000);
		 Status returnStatus = productList.removeProductFromListByProductId(2);
		 assertNotEquals(Status.REMOVED, returnStatus);
	 }
	 /**
	 * Test case to check order edit with valid order id 
	 */
	 @Test
	 public void editOrderwithValidId(){
		 productList.addProductToList(3, "UCB", "jeans", 2050);
		 Status returnStatus = productList.editProduct(3, 1000);
		 assertEquals(Status.UPDATED, returnStatus);
	 }
	 /**
	 * Test case to check order edit with Invalid order id 
	 */
	 @Test
	 public void editOrderwithInValidId(){
		 productList.addProductToList(3, "UCB", "jeans", 2050);
		 Status returnStatus = productList.editProduct(1, 1000);
		 assertNotEquals(Status.UPDATED, returnStatus);
	 }
}
