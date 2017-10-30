package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.UserDto;

public interface UserFacade {
	Iterable<UserDto> getAllUsers();
	UserDto getUserById(String username);
	boolean authenticate(String username, String password);
}
