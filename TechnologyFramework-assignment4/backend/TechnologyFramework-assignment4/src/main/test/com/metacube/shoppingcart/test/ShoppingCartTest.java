package com.metacube.shoppingcart.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.DefaultProductFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.model.Product;


/**
 * This is used to test the shopping cart application
 * 
 * @author Prateek Jain
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-mvc-servlet.xml"})
public class ShoppingCartTest {
	
	@Autowired
	ProductFacade productFacade = new DefaultProductFacade();
	
	/**
	 * Test method for testing getAllProducts.
	 */
	@Test
	public void testGetAllProducts() {
		assertNotNull(productFacade.getAllProducts());
	}

	/**
	 * Test method for testing getProductByID by passing valid id.
	 */
	@Test
	public void testGetProductByIdWhenValidId() {
		assertNotNull(productFacade.getProductById(6));
	}

	/**
	 * Test method for testing getProductByID by passing Invalid id.
	 */
	@Test
	public void testGetProductByIdWhenInValidId() {
		assertNull(productFacade.getProductById(2));
	}

	/**
	 * Test method for testing deleteProductById by passing valid id.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteProductByIdWhenValidId() {        
		assertEquals(Status.SUCCESS, productFacade.deleteProductById(5));
	}

	/**
	 * Test method for testing deleteProductById by passing Invalid id.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteProductByIdWhenInValidId() {
		assertNotEquals(Status.SUCCESS, productFacade.deleteProductById(17));
	}

	/**
	 * Test method for testing AddProduct
	 */
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setName("Reebok Shoes");
		product.setPrice(1355);
		assertEquals(Status.SUCCESS, productFacade.addProduct(product));
	}

	/**
	 * Test method for testing editProduct
	 */
	@Test
	public void testEditProduct() {
		Product product = new Product();
		product.setId(18);
		product.setName("VolleyBall");
		product.setPrice(1200);
		assertEquals(Status.SUCCESS, productFacade.editProduct(product, 18));
	}

	/**
	 * Test method for testing getProduct for valid name
	 */
	@Test
	public void testGetProductByNameWhenValid() {
		String actual = "";
		// loop till end of list reached
		for (ProductDto product : productFacade.getProductByName("chess")) {
			actual = product.getName();
		}
		assertEquals("Chess", actual);
	}

	/**
	 * Test method for testing getProduct for Invalid name
	 */
	@Test
	public void testGetProductByNameWhenInvalid() {
		String actual = "";
		// loop till end of list reached
		for (ProductDto product : productFacade.getProductByName("xyz")) {
			actual = product.getName();
		}
		assertEquals("", actual);
	}

}
