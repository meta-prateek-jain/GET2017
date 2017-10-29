package com.metacube.shoppingcart.dao.product;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateJdbcDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateProductDao.
 */
@Repository("hibernateProductDao")
public class HibernateProductDao extends HibernateJdbcDao<Product, Integer> implements ProductDao {
	/**
	 * Instantiates a new hibernate product dao.
	 */
	public HibernateProductDao() {
		super(Product.class);
	}

	/**
	 * Method is used to delete the product by id
	 */
	@Override
	public Status deleteProductById(Integer primaryKey) {
		Status result = Status.SUCCESS;
		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(getModelClass());
			Product product = (Product) criteria.add(Restrictions.eq("id", primaryKey)).uniqueResult();
			session.delete(product);
		} catch (HibernateException e) {
			System.out.println("Error: "+e);
			result = Status.ERROR_OCCURED;
		}
		return result;
	}
	

	/**
	 * Method is used to edit or save the product to list
	 */
	public <S extends Product> Status saveOrUpdateProduct(S product) {
		Status result = Status.SUCCESS;
		try {
			Session session = getSession();
			session.saveOrUpdate(product);
		} catch (HibernateException e) {
			System.out.println("Error: "+e);
			result = Status.ERROR_OCCURED;
		}
		return result;
	}
	
	/**
	 *  Method is used to get the current Session
	 *  
	 * @return
	 * 			The current session
	 */
	private Session getSession() {
		Session session = this.getSessionFactory().getCurrentSession();
		return session;
	}
	
}
