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
	 * 			json object
	 */
	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}
	
	/**
	 * Method is used to Gets the products list by name matching with the letters enter.
	 *
	 * @param id
	 *            the letters by which list is filter
	 * @return 
	 * 			  the products after filtering the list 
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
	 * @return 
	 * 			  the deleted product
	 */
	@RequestMapping(value = "/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
	return productFacade.deleteProductById(id);
	}

	/**
	 * Add the product in database
	 * 	
	 * @param product
	 * 		product to add
	 * @return 
	 * @return
	 * 		added product
	 */
	@RequestMapping(value = "/add", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Status addEmployee(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}
	
	/**
	 * edit product in the database
	 * 
	 * @param product
	 * 		product to update
	 * @param id
	 * 		id of the product
	 * @return 
	 * @return
	 * 		updated product
	 */
	@RequestMapping(value = "/edit/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Status editProduct(@RequestBody Product product,@PathVariable("id") int id) {
		return productFacade.editProduct(product,id);
	}
}
