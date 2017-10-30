package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.CartDto;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.service.CartService;

@Component("cartFacade")
public class DefaultCartFacade implements CartFacade {

	@Autowired
	CartService cartService;

	public DefaultCartFacade() {

	}

	public DefaultCartFacade(CartService cartService) {
		this.cartService = cartService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	protected Cart dtoToModel(CartDto cartDto) {
		if (cartDto == null) {
			return null;
		}
		Cart cart = new Cart();
		cart.setUserId(cartDto.getUserId());
		cart.setProductId(cartDto.getProductId());
		cart.setPname(cartDto.getPname());
		cart.setPrice(cartDto.getPrice());

		return cart;
	}

	protected CartDto modelToDto(Cart cart) {
		if (cart == null) {
			return null;
		}
		CartDto cartDto = new CartDto();
		cartDto.setUserId(cart.getUserId());
		cartDto.setProductId(cart.getProductId());
		cartDto.setPname(cart.getPname());
		cartDto.setPrice(cart.getPrice());

		return cartDto;
	}

	@Override
	public Iterable<Cart> getAll(final String id) {
		return cartService.getAll(id);

	}

	@Override
	public Cart addToCart(String pname, double price, int productId,
			String userId) {
		return cartService.addToCart(pname, price, productId, userId);
	}

	@Override
	public Boolean checkout(String id) {

		return cartService.checkout(id);
	}
}
