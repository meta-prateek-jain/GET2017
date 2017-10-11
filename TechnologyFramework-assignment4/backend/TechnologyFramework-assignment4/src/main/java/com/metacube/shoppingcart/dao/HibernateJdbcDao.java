package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The Class HibernateDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
@SuppressWarnings("unchecked")
public abstract class HibernateJdbcDao<T, ID extends Serializable> implements AbstractDao<T, ID> {

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
	public HibernateJdbcDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * Method is used to return list of products available
	 */
	@Override
	public Iterable<T> findAll() {
		Criteria criteria = createCriteria();
		List<T> personsList = criteria.list();
		return personsList;
	}

	/**
	 * Method is used to find the products list by filtering the list by name 
	 */
	
	public Iterable<T> findByName(final String name) {
		Criteria criteria = createCriteria();
		criteria = criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		List<T> personsList = criteria.list();
		return personsList;
	}
	
	/**
	 * Method is used to find product by id
	 */
	@Override
	public T findOne(final ID primaryKey) {
		Criteria criteria = createCriteria();
		criteria = criteria.add(Restrictions.eq("id", primaryKey));
		return (T) criteria.uniqueResult();
	}

	/**
	 * Method is used to get the created criteria object
	 * @return
	 * 			the criteria object
	 */
	private Criteria createCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(getModelClass());
	}

}
