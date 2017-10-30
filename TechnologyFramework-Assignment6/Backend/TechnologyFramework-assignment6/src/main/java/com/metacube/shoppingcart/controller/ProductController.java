package com.metacube.shoppingcart.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.OrderFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.Product;

/**
 * This is a controller class used to perform operation depending on path
 * 
 * @author Prateek Jain
 */
@Controller
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductFacade productFacade;

	@Autowired
	UserFacade userFacade;

	@Autowired
	CartFacade cartFacade;

	@Autowired
	OrderFacade orderFacade;

	/**
	 * Method is used to return products list as json object
	 * 
	 * @return The products list
	 */
	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getAllProducts() {
		return productFacade.getAllProducts();
	}

	/**
	 * Method is used to Get the products list by name matching with the letters
	 * enter.
	 *
	 * @param name
	 *            the letters by which list is filter
	 * @return the products list after filtering
	 */
	@RequestMapping(value = "/get", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProductByname(@RequestParam("name") String name) {
		return productFacade.getProductByName(name);
	}

	/**
	 * Method is used to get the product by its id
	 * 
	 * @param id
	 *            the id of the product
	 * @return the product
	 */
	@RequestMapping(value = "/get/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProductById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Method is used to Delete the product by id.
	 *
	 * @param id
	 *            the id
	 * @return the status of deletion operation
	 */
	@RequestMapping(value = "/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id) {
		return productFacade.deleteProductById(id);
	}

	/**
	 * Method is used to Add the product in database
	 * 
	 * @param product
	 *            product to add
	 * @return the status of adding operation
	 */
	@RequestMapping(value = "/add", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Status addEmployee(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}

	/**
	 * Method is used to edit the product in the database
	 * 
	 * @param product
	 *            product to edit
	 * @param id
	 *            id of the product
	 * @return the status of editing operation
	 */
	@RequestMapping(value = "/edit/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Status editProduct(@RequestBody Product product, @PathVariable("id") int id) {
		return productFacade.editProduct(product, id);
	}

	@SuppressWarnings("unchecked")
	/**
	 * Method is used to get the user by Id
	 * @param username
	 * 				username of the user
	 * @param password
	 * 				password of the userId
	 * @return
	 * 			User object
	 */
	@RequestMapping(value = "/getUser/{username}/{password}")
	public @ResponseBody Object getById(@PathVariable("username") String username, @PathVariable("password") String password) {
		UserDto user = userFacade.getUserById(username);
		System.out.println((user.getName()) + user.getPassword());
		/*
		 *  if user name and password match then authenticate the flag true
		 *  else set authentifate flag false 
		 */
		if ((username.equals(user.getName())) && (password.equals(user.getPassword()))) {
			JSONObject obj = new JSONObject();
			obj.put("authenticationFlag", true);
			obj.put("userId", user.getId());
			System.out.print(obj);
			return obj;
		} else {
			JSONObject obj = new JSONObject();
			obj.put("authenticationFlag", false);
			obj.put("userId", -1);
			System.out.print(obj);
			return obj;
		}
	}

	/**
	 * Method is used to get all the cart items
	 * @param id
	 * 			Id of the user
	 * @return
	 * 			Cart items list
	 */
	@RequestMapping(value = "/getAllCart/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Cart> getAllCartItems(@PathVariable("id") String id) {
		return cartFacade.getAll(id);
	}

	/**
	 * Method is used to save the product into cart
	 * 
	 * @param cart
	 * 			cart class object
	 * @return
	 * 		cart model object
	 */
	@RequestMapping(value = "/saveToCart", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Cart addtoCart(@RequestBody Cart cart) {
		return cartFacade.addToCart(cart.getPname(), cart.getPrice(), cart.getProductId(), cart.getUserId());
	}

	/**
	 * Method is used to place the order on checkout
	 * @param id
	 * 			id of the user
	 * @return
	 * 			status of the checkout
	 */
	@RequestMapping(value = "/checkout/{id}")
	public @ResponseBody Boolean deleteById(@PathVariable("id") String id) {
		return cartFacade.checkout(id);
	}

	/**
	 * 	save the order in the the list
	 * 
	 * @param id
	 * 			id of the user
	 * @param order
	 * 			order clas object
	 * @return
	 * 			status of the process
	 */
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public @ResponseBody boolean orderById(@PathVariable("id") String id, @RequestBody Order order) {
		return orderFacade.saveOrder(id, order);
	}
}
