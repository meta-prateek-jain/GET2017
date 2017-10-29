package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Cart;

/**
 * This is a service class of cart
 * @author Prateek Jain
 *
 */
public interface CartService {
	Iterable<Cart> getAll(String id);

	Cart addToCart(String pname, double price, int productId, String userId);

	Boolean checkout(String id);
}
