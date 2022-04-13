package com.bankingproject.pageobjectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	@FindBy(name ="uid")
	WebElement userID;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name= "btnLogin")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logout;
	

	public Loginpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public void setUsername(String name)
	{
		userID.sendKeys(name);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void loginButn()
	{
		loginButton.click();
	}
	
	public void logout()
	{
		logout.click();
	}
}
