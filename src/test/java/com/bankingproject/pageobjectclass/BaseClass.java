package com.bankingproject.pageobjectclass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankingproject.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();

	public static ExtentSparkReporter sparkreport;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setReport() {
		sparkreport = new ExtentSparkReporter(
				"/Users/amitparate/Desktop/Amit workspace/BankingProject/reports/htmlreport" + LocalDateTime.now()
						+ ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("Operating System", "Windows");
		extent.setSystemInfo("Enveronment", "QA");
		sparkreport.config().setReportName("Integration Test Execution");
		sparkreport.config().setDocumentTitle("QA Automation Testing Report");
		sparkreport.config().setTheme(Theme.STANDARD);

	}

	@Parameters("browser")
	@BeforeClass
	public void setup(String str) {

		if (str.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/amitparate/Documents/chromedriver");
			driver = new ChromeDriver();
			driver.get(baseURL);

		} else if (str.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/amitparate/Documents/geckodriver");
			driver = new FirefoxDriver();
		}
	}

	@AfterClass
	public void closebrowser() {
		driver.quit();
	}
	

	@AfterSuite
	public void endReport() {

		extent.flush();
		System.out.println("New Code");
	
	}

	public static String captureScreen() throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String currentDir = System.getProperty("user.dir");

		String destination = currentDir + "/screenshot/" + LocalDateTime.now() + ".png";

		FileUtils.copyFile(source, new File(destination));

		return destination;

	}

	public void method1() {
		
		System.out.println("Welcome");
		
		
	}
}
