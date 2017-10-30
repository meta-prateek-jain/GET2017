package com.metacube.shoppingcart.dao.order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateJdbcDao;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

/**
 * This class contains Method related to order
 * @author Prateek Jain
 *
 */
@Repository("hibernateOrderDao")
public class HibernateOrderDao extends HibernateJdbcDao<Order, Integer>
		implements OrderDao {
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	public HibernateOrderDao() {
		super(Order.class);
	}

	/**
	 * Method is used to save the product to cart
	 */
	@Override
	public void saveCart(List<Cart> cart, int orderId) {
		Session session = this.sessionFactory.getCurrentSession();
		session.createCriteria(getModelClass());
		OrderDetail ordet = null;
		// loop continue till end of the cart items 
		for (Cart cartObj : cart) {

			ordet = new OrderDetail();

			ordet.setOrderId(orderId);
			ordet.setPname(cartObj.getPname());
			ordet.setPrice(cartObj.getPrice());
			ordet.setQuantity(1);

			session.save(ordet);
		}

	}

}
