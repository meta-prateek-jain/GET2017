package com.metacube.shoppingcart.controller;

import java.util.List;

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
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.model.Product;


/**
 * This is a controller class used to perform operation depending on path

 *  @author Prateek Jain
 */
@Controller
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductFacade productFacade;

	/**
	 * Method is used to return products list as json object
	 * 
	 * @return
	 * 			The products list
	 */
	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getAllProducts() {
		return productFacade.getAllProducts();
	}
	
	/**
	 * Method is used to Get the products list by name matching with the letters enter.
	 *
	 * @param name
	 *            the letters by which list is filter
	 * @return 
	 * 			  the products list after filtering 
	 */
	@RequestMapping(value = "/get", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProductByname(@RequestParam("name") String name) {
		return productFacade.getProductByName(name);
    }
	
	/**
	 * Method is used to get the product by its id
	 * 
	 * @param id
	 * 			the id of the product
	 * @return
	 * 			the product
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
	 * @return 
	 * 			  the status of deletion operation
	 */
	@RequestMapping(value = "/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
	return productFacade.deleteProductById(id);
	}

	/**
	 * Method is used to Add the product in database
	 * 	
	 * @param product
	 * 				product to add
	 * @return
	 * 		 		the status of adding operation
	 */
	@RequestMapping(value = "/add", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Status addEmployee(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}
	
	/**
	 * Method is used to edit the product in the database
	 * 
	 * @param product
	 * 					product to edit
	 * @param id
	 * 					id of the product
	 * @return
	 * 					the status of editing operation
	 */
	@RequestMapping(value = "/edit/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Status editProduct(@RequestBody Product product, @PathVariable("id") int id) {
		return productFacade.editProduct(product,id);
	}
}
