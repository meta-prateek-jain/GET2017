package com.metacube.shoppingcart.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Factory class to get object
 * 
 * @author Prateek Jain
 */
public class Factory {
	
	/** The application context. */
	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}
}
