package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.User;

public interface UserService {
	Iterable<User> getAllUsers();
	User getUserById(String id);
}
