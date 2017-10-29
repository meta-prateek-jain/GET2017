package com.metacube.shoppingcart.dao.user;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateJdbcDao;
import com.metacube.shoppingcart.model.User;

@Repository("hibernateUserDao")

/**
 * this class extends base abstract class to continue
 * @author Prateek Jain
 *
 */
public class HibernateUserDao extends HibernateJdbcDao<User, Integer>
implements
UserDao {
	public HibernateUserDao() {
		super(User.class);
	}
}
