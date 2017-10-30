package com.metacube.testautomation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test class to check create an account and forgot password on web page
 * 
 * @author Prateek Jain
 * Dated:- 11/10/2017
 *
 */
public class TestWebPage {
	WebDriver driverChrome;

	/**
	 * This is used to setUp the driver object before running the test 
	 * and go to that site which is going to be tested.
	 * 
	 * @throws InterruptedException
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		driverChrome = new ChromeDriver();
		driverChrome.get("http://automationpractice.com/index.php");
	}

	/**
	 * This test case is used to test the forgot password link is working correct or not
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void testForgotPassword() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		driverChrome.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		assertEquals(driverChrome.getTitle(), "Forgot your password - My Store");
	}

	/**
	 * This test case is used to test the create an account button is
	 *  redirecting to account creation page or not
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void testCreateAccount() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverChrome.findElement(By.id("email_create")).sendKeys("abcde@example.com");
		driverChrome.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(4000);
		assertEquals(driverChrome.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		Thread.sleep(2000);
	}

	/**
	 * This test case is used to tear down the driver.
	 * 
	 * @throws InterruptedException
	 */
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driverChrome.close();
	}
}
