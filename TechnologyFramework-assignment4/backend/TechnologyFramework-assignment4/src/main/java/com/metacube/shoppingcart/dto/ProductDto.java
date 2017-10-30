package com.metacube.shoppingcart.dto;

/**
 * DTO class of product POJO used to transfer the data between different layers.
 */
public class ProductDto
{
	private int id;
	private String name;
	private double price;
	
	// getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

}
