package com.bankingproject.testclass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bankingproject.pageobjectclass.BaseClass;
import com.bankingproject.pageobjectclass.Loginpage;
import com.bankingproject.pageobjectclass.NewCustomer;

public class TC_LoginTest_003 extends BaseClass {

	@Test
	public void newCustomerTest() throws InterruptedException {
		driver.get(baseURL);
		test = extent.createTest("Verify application login");

		Loginpage login = new Loginpage(driver);
		login.setUsername(username);
		test.log(Status.PASS, "username successfully entered");

		login.setPassword(password);
		test.log(Status.PASS, "password successfully entered");

		login.loginButn();
		test.log(Status.PASS, "clicked on login button");

		NewCustomer newcustomer = new NewCustomer(driver);
		
		newcustomer.selectNewCustomer();
		
		Thread.sleep(5000);
		test.log(Status.PASS, "clicked on new customer button");
		
		newcustomer.selectDOB("12","03", "1992");
		test.log(Status.PASS, "DOB entered");
		
		Thread.sleep(5000);

	}

}
