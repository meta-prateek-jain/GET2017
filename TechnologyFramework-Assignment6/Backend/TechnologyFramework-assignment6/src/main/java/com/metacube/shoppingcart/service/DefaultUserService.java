package com.metacube.shoppingcart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.user.UserDao;
import com.metacube.shoppingcart.model.User;

/**
 * Method is used to get the user 
 * @author Prateek Jain
 *
 */
@Service("userService")
@Transactional
public class DefaultUserService implements UserService {
	@Resource(name = "hibernateUserDao")
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(final String id) {
		return userDao.getOne(id);
	}
}
