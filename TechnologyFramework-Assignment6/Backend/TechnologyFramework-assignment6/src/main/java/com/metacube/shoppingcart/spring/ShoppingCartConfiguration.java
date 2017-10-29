package com.metacube.shoppingcart.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.dao.cart.HibernateCartDao;
import com.metacube.shoppingcart.dao.order.HibernateOrderDao;
import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.dao.product.HibernateProductDao;
import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.dao.user.HibernateUserDao;
import com.metacube.shoppingcart.dao.user.UserDao;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.DefaultCartFacade;
import com.metacube.shoppingcart.facade.DefaultOrderFacade;
import com.metacube.shoppingcart.facade.DefaultProductFacade;
import com.metacube.shoppingcart.facade.DefaultUserFacade;
import com.metacube.shoppingcart.facade.OrderFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.service.CartService;
import com.metacube.shoppingcart.service.DefaultCartService;
import com.metacube.shoppingcart.service.DefaultOrderService;
import com.metacube.shoppingcart.service.DefaultProductService;
import com.metacube.shoppingcart.service.DefaultUserService;
import com.metacube.shoppingcart.service.OrderService;
import com.metacube.shoppingcart.service.ProductService;
import com.metacube.shoppingcart.service.UserService;

/**
 * The Class MyConfiguration is the configuration class of this application.
 */
@Configuration
@ComponentScan("com.metacube.shoppingcart.facade")
public class ShoppingCartConfiguration {

	/**
	 * Gets the jdbc product dao.
	 *
	 * @return the Product dao object
	 */
	@Bean(name = "productDao")
	public ProductDao getJdbcProductDao() {
		HibernateProductDao productDao = new HibernateProductDao();
		return productDao;
	}

	/**
	 * Gets the default product service.
	 *
	 * @return the default product service
	 */
	@Bean(name = "productService")
	public ProductService getDefaultProductService() {
		DefaultProductService productService = new DefaultProductService(getJdbcProductDao());
		return productService;
	}

	/**
	 * Gets the default product facade.
	 *
	 * @return the default product facade
	 */
	@Bean(name = "productFacade")
	public ProductFacade getDefaultProductFascade() {
		DefaultProductFacade productFacade = new DefaultProductFacade();
		return productFacade;
	}
	
	/**
	 * Gets the jdbc product dao.
	 *
	 * @return the Product dao object
	 */
	@Bean(name = "userDao")
	public UserDao getJdbcUserDao() {
		HibernateUserDao userDao = new HibernateUserDao();
		return userDao;
	}

	/**
	 * Gets the default product service.
	 *
	 * @return the default product service
	 */
	@Bean(name = "userService")
	public UserService getDefaultUserService() {
		DefaultUserService userService = new DefaultUserService();
		return userService;
	}

	/**
	 * Gets the default product facade.
	 *
	 * @return the default product facade
	 */
	@Bean(name = "userFacade")
	public UserFacade getDefaultUserFascade() {
		DefaultUserFacade userFacade = new DefaultUserFacade();
		return userFacade;
	}
	
	@Bean(name = "orderDao")
	public OrderDao getJdbcOrderDao() {
		HibernateOrderDao orderDao = new HibernateOrderDao();
		return orderDao;
	}

	/**
	 * Gets the default product service.
	 *
	 * @return the default product service
	 */
	@Bean(name = "orderService")
	public OrderService getDefaultOrderService() {
		DefaultOrderService orderService = new DefaultOrderService();
		return orderService;
	}

	/**
	 * Gets the default product facade.
	 *
	 * @return the default product facade
	 */
	@Bean(name = "orderFacade")
	public OrderFacade getDefaultOrderFascade() {
		DefaultOrderFacade orderFacade = new DefaultOrderFacade();
		return orderFacade;
	}
	@Bean(name = "cartDao")
	public CartDao getJdbcCartDao() {
		HibernateCartDao cartDao = new HibernateCartDao();
		return cartDao;
	}

	/**
	 * Gets the default product service.
	 *
	 * @return the default product service
	 */
	@Bean(name = "cartService")
	public CartService getDefaultCartService() {
		DefaultCartService cartService = new DefaultCartService();
		return cartService;
	}

	/**
	 * Gets the default product facade.
	 *
	 * @return the default product facade
	 */
	@Bean(name = "cartFacade")
	public CartFacade getDefaultCartFascade() {
		DefaultCartFacade cartFacade = new DefaultCartFacade();
		return cartFacade;
	}
}