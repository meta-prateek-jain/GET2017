package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.model.Order;

public interface OrderFacade {

	boolean saveOrder(String id, Order order);

}
