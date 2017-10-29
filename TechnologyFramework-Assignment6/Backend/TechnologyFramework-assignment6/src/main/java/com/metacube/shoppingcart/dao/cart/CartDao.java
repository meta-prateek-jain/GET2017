package com.metacube.shoppingcart.dao.cart;

import com.metacube.shoppingcart.dao.AbstractDao;
import com.metacube.shoppingcart.model.Cart;

/**
 * Interface class of cart Dao
 * 
 * @author Prateek Jain
 *
 */
public interface CartDao extends AbstractDao<Cart, String> {
	Iterable<Cart> getAll(final String id);

	Cart addToCart(String pname, double price, int productId, String userId);
	boolean deleteFromCart(String username);

}
