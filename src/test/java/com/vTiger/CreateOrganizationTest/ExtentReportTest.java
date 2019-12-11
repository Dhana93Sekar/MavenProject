package com.vTiger.CreateOrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportTest 
{
	
	public static void main(String[]args)   
	{
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("C:\\Users\\lenovo\\extentreport\\Report.html");
		
		htmlreport.config().setDocumentTitle("Testing Amazon App");
		htmlreport.config().setReportName("Amazon Home Page Testing");
		htmlreport.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("platform", "Windows 10");
		extent.setSystemInfo("Author", "Dhanasekar");
		ExtentTest test = extent.createTest("AmazonTest");
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		test.log(Status.INFO, "Launching the Browser");
		
		driver.get("https://www.amazon.in");
		test.log(Status.INFO,"Loding amazon application");	
		
		String expTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		String actTitle = driver.getTitle();
		
		if(expTitle.contains(actTitle))
		{
			test.log(Status.INFO, "Applicatin Launched Succesfully");
		}
		
		extent.flush();
		driver.close();
	}
	
}
