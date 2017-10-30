package com.metacube.shoppingcart.dao.cart;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateJdbcDao;
import com.metacube.shoppingcart.model.Cart;

/**
 * Method related to cart  is present in this class
 * @author Prateek Jain
 *
 */
@Repository("hibernateCartDao")
public class HibernateCartDao extends HibernateJdbcDao<Cart, String> implements
		CartDao {
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	public HibernateCartDao() {
		super(Cart.class);
	}

	/**
	 * Method is used to get all the users
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Cart> getAll(final String id) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(getModelClass());
		criteria = criteria.add(Restrictions.eq("userId", id));
		List<Cart> productList = criteria.list();
		return productList;
	}

	/**
	 * Method is used to get the current session
	 * @return
	 */
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}

	/**
	 * Method is used to add the product to cart
	 */
	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {

		Session session = getSession();
		Cart cart = new Cart();
		cart.setPname(pname);
		cart.setPrice(price);
		cart.setProductId(productId);
		cart.setUserId(userId);
		cart.setQuantity(1);

		session.save(cart);

		return cart;
	}

	/**
	 * Method is used to delete the item from the cart
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteFromCart(final String username) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(getModelClass());
		boolean result = true;
		criteria = criteria.add(Restrictions.eq("userId", username));
		List<Cart> productList = criteria.list();
		// loop continue till list end
		for (Cart product : productList) {
			session.delete(product);
		}
		return result;

	}
}
