package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.service.ProductService;

/**
 * Product facade class is used to get and post data to server
 * 
 * @author Prateek Jain
 */
@Component("productFacade")
public class DefaultProductFacade implements ProductFacade
{
	@Autowired
	ProductService productService;

	public DefaultProductFacade() {

	}
	
	/**
	 * Constructor to initialize the productList
	 * @param productService
	 */
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}


	/**
	 * Method is used to set the product service object
	 */
	public void setProductService(final ProductService productService) {
		this.productService = productService;
	}
	
	/**
	 * Method is used to retrieve all products
	 */
	@Override public List<ProductDto> getAllProducts()
	{
		List<ProductDto> productDtoList = new ArrayList<>();
		
		// loop continue till end of products list reached
		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}
		return productDtoList;
	}

	/**
	 * Method is used to retrieve product by its id
	 */
	@Override public ProductDto getProductById(final int id) {
		return modelToDto(productService.getProductById(id));
	}

	/**
	 * Method is used to convert the dto object for mobile 
	 * @param productDto
	 * 			product dto object
	 * @return
	 * 	`		product model object
	 */
	protected Product dtoToModel(ProductDto productDto) {
		// if productDto is null then return
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		return product;
	}

	/**
	 * Method is used to convert data to Dto object 
	 * @param product
	 * 			product model object
	 * @return
	 * 			product dto object
	 */
	protected ProductDto modelToDto(Product product) {
		// if productDto is null then return
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}

	/**
	 * Method is used to delete the product
	 */
	@Override
	public Status deleteProductById(int id) {
		return productService.deleteProductById(id);
	}
	
	/**
	 * Method is used to add the product
	 */
	@Override
	public Status addProduct(Product product) {
		return productService.addProduct(product);
	}
	
	/**
	 * Method is used to edit the product
	 */
	@Override
	public Status editProduct(Product product,int id) {
		return productService.editProduct(product,id);
	}

	/**
	 * Method is used to get the productList after filtering by name
	 */
	@Override
	public List<ProductDto> getProductByName(String name) {
		List<ProductDto> productDtoList = new ArrayList<>();
		// loop continue till end of productList reached
		for (Product product : productService.getProductByName(name)) {
			productDtoList.add(modelToDto(product));
		}
		return productDtoList;
	}
}
