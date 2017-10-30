package com.metacube.shoppingcart.dao.order;

import java.util.List;

import com.metacube.shoppingcart.dao.AbstractDao;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;

/**
 * Interface class of order
 * @author Prateek Jain
 *
 */
public interface OrderDao extends AbstractDao<Order, Integer> {
	void saveCart(List<Cart> cart, int orderId);
}
