package com.Docker.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	DesiredCapabilities dc;
	 WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_Browser() throws MalformedURLException {

		     String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				System.out.println("Running in remote.....");
				init_RemoteDriver("chrome");
			} else {

				System.out.println("Running in local......");
				WebDriverManager.chromedriver().setup();
				tldriver.set(new ChromeDriver());
			}
		} else if (browserName.equals("firefox")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				System.out.println("Running in remote.....");

				init_RemoteDriver("firefox");
			}

			else {
				System.out.println("Running in local.......");
				WebDriverManager.firefoxdriver().setup();
				tldriver.set(new FirefoxDriver());
			}
		} else if (browserName.equals("edge")) {
			System.out.println("Running in remote.....");

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_RemoteDriver("edge");
			}

			else {
				System.out.println("Running in local.......");
				WebDriverManager.edgedriver().setup();
				tldriver.set(new EdgeDriver());
			}
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	private void init_RemoteDriver(String BrowserName) {
		dc = new DesiredCapabilities();
		System.out.println("Running in the given browser name ::" + BrowserName);

		if (BrowserName.equals("chrome")) {

			try {
				dc.setBrowserName("chrome");
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), dc);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (BrowserName.equals("edge")) {
			try {
				dc.setBrowserName("edge");
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), dc);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} else if (BrowserName.equals("firefox")) {
			try {
				dc.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), dc);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

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
