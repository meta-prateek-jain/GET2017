package com.metacube.shoppingcart.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Factory class to get object
 * 
 * @author Prateek Jain
 */
public class ApplicationContextFactory {
	
	/** The application context. */
	static ApplicationContext applicationContext;

	static {
		applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
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