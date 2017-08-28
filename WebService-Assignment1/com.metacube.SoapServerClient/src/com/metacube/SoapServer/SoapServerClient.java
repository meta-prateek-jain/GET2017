package com.metacube.SoapServer;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

/**
 * This is a Client side class which calls server to convert the temperature
 * from fahrenheit to celsius
 * 
 * @author Prateek Jain
 *
 */
public class SoapServerClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SoapServerClient webServiceClient = new SoapServerClient();
		System.out.println("Enter temperature in fahrenheit");
		double temperature;
		// loop continue till user enter correct input
		while (!scan.hasNextDouble()) {
			System.out.println("Enter only Integers");
			scan.next();
		}
		temperature = scan.nextDouble();
		System.out.printf("Temperature in celsius is: %.2f\n",
				webServiceClient.convertor(temperature));
		scan.close();
	}

	/**
	 * Function is sending temperature value to server and getting the converted
	 * value and return the value
	 * 
	 * @param temperature
	 * @return
	 */
	public double convertor(double temperature) {
		// Create the locator object to locate the server
		FahrenheitToCelsiusServiceLocator locatorObject = new FahrenheitToCelsiusServiceLocator();
		double result = 0;
		// setting the locator end point address
		locatorObject.setFahrenheitToCelsiusEndpointAddress("http://localhost:8080/com.metacube.SoapServer/services/FahrenheitToCelsius");
		try {
			FahrenheitToCelsius temperatureConversion = locatorObject.getFahrenheitToCelsius();
			result = temperatureConversion.convertFahrenheitToCelsius(temperature);
		} catch (ServiceException | RemoteException e) {
			System.out.println("Error in connection.");
		} catch (Exception e) {
			System.out.println("Error occured.");
		}
		return result;
	}

}