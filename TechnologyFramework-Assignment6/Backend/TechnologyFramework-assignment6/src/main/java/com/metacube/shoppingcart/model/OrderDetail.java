package com.metacube.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetail")
public class OrderDetail {

	@Id
	@Column(name = "orderDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;

	@Column(name = "pname")
	private String pname;

	@Column(name = "price")
	private double price;

	@Column(name = "orderId")
	private int orderId;

	@Column(name = "quantity")
	private int quantity;

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
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

	public void setPrice(double d) {
		this.price = d;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
