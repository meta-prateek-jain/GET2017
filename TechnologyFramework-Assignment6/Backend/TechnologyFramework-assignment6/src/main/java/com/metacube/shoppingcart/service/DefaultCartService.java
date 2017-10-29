package com.metacube.shoppingcart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.model.Cart;

/**
 * Methods related to cart operations 
 * 
 * @author prateek jain
 *
 */
@Service("cartService")
@Transactional
public class DefaultCartService implements CartService {

	@Resource(name = "hibernateCartDao")
	CartDao cartDao;

	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;

	/**
	 * Method is used to get all product list
	 */
	@Override
	public Iterable<Cart> getAll(final String id) {
		return cartDao.getAll(id);
	}

	/**
	 * Method is used to get the cart dao
	 * @return
	 */
	public CartDao getCartDao() {
		return cartDao;
	}

	
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * Method is used to add the item to list 
	 */
	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {
		return cartDao.addToCart(pname, price, productId, userId);
	}

	/**
	 * Method is used to checkout 
	 */
	@Override
	public Boolean checkout(String id) {

		return cartDao.deleteFromCart(id);
	}

}
