package com.Docker.Test;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Docker.Factory.BrowserFactory;

public class TestingChromeBrowser extends BrowserFactory {

	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		prop = init_Properties();
		driver = init_Browser("chrome");
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void testPageTitle() {

		System.out.println(driver.getTitle() + " is for chrome");
		String title=driver.getTitle();
		Assert.assertEquals("Account Login", title);
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
