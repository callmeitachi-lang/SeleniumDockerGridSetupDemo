package com.Docker.Test;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Docker.Factory.BrowserFactory;
import com.Docker.LoginPage.LoginPage;

public class TestingChromeBrowser {
	WebDriver driver;
	Properties prop;
	BrowserFactory browserfactory;
	LoginPage loginpage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws MalformedURLException {
		browserfactory = new BrowserFactory();
		prop = browserfactory.init_Properties();
		if (browser != null) {
			prop.setProperty("browser", browser);
			// this will set a prop browser as browser
		}
		driver = browserfactory.init_Browser();
		loginpage = new LoginPage(driver);

	}

	@Test
	public void testPageTitle() {
		Assert.assertEquals(loginpage.getTitle(), "Account Login");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
