package com.metacube.SoapServer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Test Class to check the functionality of function with different input
 * 
 * @author Prateek Jain
 *
 */
public class FahrenheitToCelsiusTest {
	FahrenheitToCelsius temperatureCovertor;
	/**
	 * Function is initializing the object before testing
	 */
	@Before
	public void setUpObject() {
		temperatureCovertor = new FahrenheitToCelsius();
	}
	/**
	 * Testing function when Input is Positive
	 */
	@Test
	public void testConversionWithPositiveInput() {
		double actual = temperatureCovertor.convertFahrenheitToCelsius(300);
		assertEquals(148.8, actual, 0.1);
	}
	/**
	 * Testing function when Input is zero
	 */
	@Test
	public void testConversionWithZeroInput() {
		double actual = temperatureCovertor.convertFahrenheitToCelsius(0);
		assertEquals(-17.7, actual, 0.1);
	}
	/**
	 * Testing function when input is negative
	 */
	@Test
	public void testConversionWithNegativeInput() {
		double actual = temperatureCovertor.convertFahrenheitToCelsius(-4);
		assertEquals(-20.0, actual, 0.1);
	}
	/**
	 * Negative test case 
	 */
	@Test
	public void testConversionWithInValidOutput() {
		double actual = temperatureCovertor.convertFahrenheitToCelsius(300);
		assertNotEquals(14.8, actual, 0.1);
	}
}