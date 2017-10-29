package com.metacube.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	@Column(name = "userId")
	private String userId;

	/** The name. */
	@Column(name = "pname")
	private String pname;

	/** The price. */
	@Column(name = "price")
	private double price;

	@Column(name = "productId")
	private int productId;

	@Column(name = "quantity")
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", pname="
				+ pname + ", price=" + price + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}

}
