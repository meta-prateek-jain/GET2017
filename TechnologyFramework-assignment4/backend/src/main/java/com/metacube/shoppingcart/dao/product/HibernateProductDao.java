package com.metacube.shoppingcart.dao.product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateProductDao.
 */
@Repository("hibernateProductDao")
public class HibernateProductDao extends HibernateDao<Product, Integer> implements ProductDao {
	/**
	 * Instantiates a new hibernate product dao.
	 */
	public HibernateProductDao() {
		super(Product.class);
	}
	
	/**
	 * Method is used to Edit the detail of a product
	 * 
	 * @param product
	 *            		product to edit
	 * @param primaryKey
	 *            		primary key of table
	 * @return 			status of operation
	 */
	@Override
	public Status editProduct(Product product, Integer primaryKey) {
		Status result = Status.SUCCESS;
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(product);
		return result;
	}
	
	/**
	 * Method is used to delete the product by id
	 */
	@Override
	public Status deleteProductById(Integer primaryKey) {
		Status result = Status.SUCCESS;
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		Product product = (Product) criteria.add(Restrictions.eq("id", primaryKey));
		session.delete(product);
		return result;

	}
}
