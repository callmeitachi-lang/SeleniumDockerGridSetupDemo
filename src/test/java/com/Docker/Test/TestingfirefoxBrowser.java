package com.Docker.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Docker.Factory.BrowserFactory;

public class TestingfirefoxBrowser extends BrowserFactory {

	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setup() {
		prop = init_Properties();

		driver = init_Browser("firefox");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void testPageTitle() {

		System.out.println(driver.getTitle() + "is for firefox");
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}
}
