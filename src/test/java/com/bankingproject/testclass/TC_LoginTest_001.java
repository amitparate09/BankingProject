package com.bankingproject.testclass;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.bankingproject.pageobjectclass.BaseClass;
import com.bankingproject.pageobjectclass.Loginpage;
import com.bankingproject.pageobjectclass.NewCustomer;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws Exception {

		driver.get(baseURL);

		test = extent.createTest("Verify application login");

		Loginpage login = new Loginpage(driver);
		login.setUsername(username);
		test.log(Status.PASS, "username successfully entered");

		login.setPassword(password);
		test.log(Status.PASS, "password successfully entered");

		login.loginButn();
		test.log(Status.PASS, "clicked on login button");

		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {

			test.log(Status.PASS, "user successfully logged in to the aaplication");

		} else {

			test.log(Status.FAIL, "Log in failed");
			String screenshotpath = BaseClass.captureScreen();
			test.addScreenCaptureFromPath(screenshotpath);
		}
	}

}
