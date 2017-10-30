package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.model.User;
import com.metacube.shoppingcart.service.UserService;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
	@Autowired
	UserService userService;

	public DefaultUserFacade() {

	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public DefaultUserFacade(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Iterable<UserDto> getAllUsers() {
		List<UserDto> userDtoList = new ArrayList<>();

		for (User user : userService.getAllUsers()) {
			userDtoList.add(modelToDto(user));
		}

		return userDtoList;
	}

	@Override
	public UserDto getUserById(final String id) {
		return modelToDto(userService.getUserById(id));
	}

	protected User dtoToModel(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		return user;
	}

	protected UserDto modelToDto(User user) {
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());

		return userDto;
	}

	@Override
	public boolean authenticate(String username, String password) {
		return false;
	}
}
