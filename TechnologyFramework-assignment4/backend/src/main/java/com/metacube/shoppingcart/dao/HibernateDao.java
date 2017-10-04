package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class HibernateDao<T, ID extends Serializable> implements AbstractDao<T, ID> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** The model class. */
	private Class<T> modelClass;

	/**
	 * Gets the model class.
	 *
	 * @return the model class
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Instantiates a new hibernate dao.
	 *
	 * @param modelClass
	 *            the model class
	 */
	public HibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * Method is used to return list of products available
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		List<T> personsList = criteria.list();
		return personsList;
	}

	/**
	 * Method is used to find the products list by filtering the list by name 
	 */
	@SuppressWarnings("unchecked")
	public Iterable<T> findByName(final String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		criteria = criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		List<T> personsList = criteria.list();
		return personsList;
	}
	
	/**
	 * Method is used to find product by id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findOne(final ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		criteria = criteria.add(Restrictions.eq("id", primaryKey));
		return (T) criteria.uniqueResult();
	}

	/**
	 * Method is used to save the new product to list
	 */
	public <S extends T> Status save(S entity) {
		Status result = Status.SUCCESS;
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) entity;
		if (session.save(product) == null ) {
			result = Status.ERROR_OCCURED;
		}
		return result;

	}
	
}
