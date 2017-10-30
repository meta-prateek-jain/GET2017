package com.metacube.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;

/**
 * Order service class to perform operation related to order 
 * @author Prateek Jain
 *
 */
@Service("orderService")
@Transactional
public class DefaultOrderService implements OrderService {
	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;
	@Resource(name = "cartService")
	CartService cartService;
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	/**
	 * Method isused to save the order into cart
	 */
	public boolean saveCart(String id, Order order) {

		int orderId = orderDao.saveOrder(id, order);
		Iterable<Cart> cart = cartService.getAll(id);
		System.out.println(cart.getClass());
		System.out.println(cart.toString());
		Cart carts;
		List<Cart> cartModel = new ArrayList<Cart>();
		// loop continue till end of the cart list reached
		for (Cart cartObj : cart) {

			carts = new Cart();

			carts.setPname(cartObj.getPname());
			carts.setPrice(cartObj.getPrice());
			carts.setQuantity(1);

			cartModel.add(carts);

		}
		orderDao.saveCart(cartModel, orderId);
		return true;

	}
}
