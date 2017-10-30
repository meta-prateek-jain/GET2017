package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Order;

public interface OrderService {

	boolean saveCart(String id, Order order);

}
