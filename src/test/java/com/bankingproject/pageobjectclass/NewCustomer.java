package com.bankingproject.pageobjectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	static WebDriver ldriver;

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement customerName;
	
	@FindBy(name = "dob")
	WebElement dob;
	
	public NewCustomer(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void selectNewCustomer()
	{
		customerName.click();
	}
	
	public void selectDOB(String dd,String mm, String yyyy)
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
		
		
		
	}
	
}
