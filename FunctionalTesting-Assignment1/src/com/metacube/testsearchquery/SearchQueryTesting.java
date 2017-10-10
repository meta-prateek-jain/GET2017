package com.metacube.testsearchquery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class is used to setup driver to run script 
 * 
 * @author Prateek Jain
 *
 */
public class SearchQueryTesting {
	public static void main(String[] args) {
		try {
			/*System.setProperty("webdriver.ie.driver", "D:\\Downloads\\chromedrivernew_win32-20171009T063022Z-001\\IEDriverServer_Win32_3.6.0\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("marionette", true);*/
			WebDriver driver = new InternetExplorerDriver();
			driver.get("http://automationpractice.com/index.php");
			Thread.sleep(1000);
			driver.findElement(By.id("search_query_top")).click();
			driver.findElement(By.id("search_query_top")).sendKeys("Faded");
			driver.findElement(By.name("submit_search")).click();
//			Thread.sleep(6000);
//			driver.quit();
		} catch (InterruptedException e) {
			System.out.println("Error: "+e);
		}
	}
}
