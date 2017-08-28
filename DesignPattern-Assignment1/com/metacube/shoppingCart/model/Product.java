package com.metacube.shoppingCart.model;

/**
 * Class has all properties related to product
 * 
 * @author Prateek Jain
 *
 */
public class Product extends BaseEntity{
	private String name;
	private double price;
	private String type;
	
	/**
	 * constructor to initialize the properties
	 * @param details
	 */
	public Product(String[] details) {
		this.setId(Integer.parseInt(details[0]));
		name = details[1];
		type = details[2];
		price = Double.parseDouble(details[3]);
	}

	//getters and setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	public void setPrice(double d) {
		this.price = d;
	}
	/*
	 * Function override the to string function to display the product details
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return "\n"+getId()+"-->"+getName()+"-->"+getType()+"--> Price :  Rs "
					+ getPrice()
					+"\n";
    }
}
