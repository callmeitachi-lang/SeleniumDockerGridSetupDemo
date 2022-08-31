package com.Docker.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	DesiredCapabilities dc;
	WebDriver driver;
	Properties prop;

	public WebDriver init_Browser(String browserName) {
		dc = new DesiredCapabilities();

		if (browserName.equals("chrome")) {

			dc.setBrowserName("chrome");
		} else if (browserName.equals("firefox")) {

			dc.setBrowserName("firefox");
		} else if (browserName.equals("edge")) {
			dc.setBrowserName("MicrosoftEdge");
		} else {
			System.out.println("Please check the browsername ::" + browserName);
		}
		try {
			driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;

	}

	public Properties init_Properties() {

		prop = new Properties();
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("./src/main/java/com/Docker/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
