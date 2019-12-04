package com.vTiger.genericLib;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImpClass implements ITestListener ,IRetryAnalyzer{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String currentDate = new Date().toString().replace(":", "_").replace(" ", "_");
		String failedTCName = result.getMethod().getMethodName();

		System.out.println("====FAILED======>"+failedTCName);

		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver2);

		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/"+failedTCName+"_"+currentDate+".png");
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e)
		{
			System.out.println(e);
		}


	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	private int count = 0;
	private static int maxTry = 3;

	@Override
	public boolean retry(ITestResult iTestResult)
	{
		if (!iTestResult.isSuccess()) {                      //Check if test not succeed
			if (count < maxTry) {                            //Check if maxtry count is reached
				count++;                                     //Increase the maxTry count by 1
				iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
				return true;                                 //Tells TestNG to re-run the test
			} else {
				iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
		}
		return false;
	}

}
