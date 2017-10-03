package com.metacube.shoppingcart.model;

/**
 * Basic product list model class containing all its required properties
 */
public class Product {
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
