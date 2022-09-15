package com.Docker.LoginPage;

import org.openqa.selenium.WebDriver;

public class LoginPage  {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public String getTitle()
	{
		
		String title=driver.getTitle();
		 System.out.println("The title of the page is "+title);
       
		return title; 
	}
	

}
