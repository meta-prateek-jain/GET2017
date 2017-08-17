package com.metacube.SoapServer;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * This class is a backend server class which perform the conversion function 
 * 
 * @author Prateek Jain
 *Dated:- 16/08/2017
 */
@WebService
public class FahrenheitToCelsius {

	/**
	 * Function is used to convert the temperature from fahrenheit to celsius 
	 * 
	 * @param temperature
	 * @return
	 */
	@WebMethod
	public double convertFahrenheitToCelsius(double temperature) {
		temperature = ((temperature - 32) * 5) / 9;
		return temperature;
	}
}