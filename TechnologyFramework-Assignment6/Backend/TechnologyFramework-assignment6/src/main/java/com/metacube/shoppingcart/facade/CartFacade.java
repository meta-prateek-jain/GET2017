package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.model.Cart;

public interface CartFacade {

	Iterable<Cart> getAll(final String id);

	Cart addToCart(String pname, double price, int productId, String userId);

	Boolean checkout(String id);

}
