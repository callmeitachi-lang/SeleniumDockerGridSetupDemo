package com.Docker.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionalManagers {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public ChromeOptions chromeOptions() {

		co = new ChromeOptions();
		if (Boolean.valueOf(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
			if (Boolean.valueOf(prop.getProperty("headless")))
				co.setHeadless(true);
		}
		return co;
	}

	public FirefoxOptions firefoxOptions() {

		fo = new FirefoxOptions();
		if (Boolean.valueOf(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
			if (Boolean.valueOf(prop.getProperty("headless")))
				co.setHeadless(true);
		}
		return fo;
	}

}
