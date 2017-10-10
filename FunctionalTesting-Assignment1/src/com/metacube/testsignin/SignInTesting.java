package com.metacube.testsignin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test class to perform automatic testing of sign in button
 * 
 * @author Prateek Jain
 *
 */
public class SignInTesting {
	WebDriver driver;

	/**
	 * Method is used to setUp the object
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		/*System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);*/
		driver = new FirefoxDriver();
		System.out.println("In Before Test");
		driver.get("http://automationpractice.com/");
		Thread.sleep(1000);
	}

	/**
	 * Method is used to test sign in
	 */
	@Test
	public void signinTest() throws InterruptedException {
		driver.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("Test@example.com");
		driver.findElement(By.id("passwd")).sendKeys("Test");
		driver.findElement(By.id("SubmitLogin")).click();
	}

	/**
	 * Method is used to tear down the driver
	 */
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(6000);
		// driver.quit();
	}
}
