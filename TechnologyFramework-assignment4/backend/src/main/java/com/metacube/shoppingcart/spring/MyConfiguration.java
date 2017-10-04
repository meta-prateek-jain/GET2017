package com.metacube.shoppingcart.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.metacube.shoppingcart.dao.product.HibernateProductDao;
import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.facade.DefaultProductFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.service.DefaultProductService;
import com.metacube.shoppingcart.service.ProductService;

/**
 * The Class MyConfiguration is the configuration class of this application.
 */
@Configuration
@ComponentScan("com.metacube.shoppingcart.facade")
public class MyConfiguration {

	/**
	 * Gets the jdbc product dao.
	 *
	 * @return the jdbc Product dao
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
	public ProductService getDefaultUserService() {
		DefaultProductService productService = new DefaultProductService(
				getJdbcProductDao());

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
}