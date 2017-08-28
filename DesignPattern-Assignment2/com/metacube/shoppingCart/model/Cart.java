package com.metacube.shoppingCart.model;

/**
 * Class contains properties of cart
 *  
 * @author Prateek Jain
 *
 */
public class Cart extends BaseEntity{
	int quantity;
	Product product;
	//getters and setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/*
	 * Function override the to string function to display the cart details
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return "\n"+getId()+"-->"+product.getName()+"-->"+product.getType()+"--> Price :  Rs "
					+ getProduct().getPrice()
					+ "*"
					+ getQuantity()
					+ " = Rs "
					+ getProduct().getPrice()
					* getQuantity()+"\n";
    }
}
