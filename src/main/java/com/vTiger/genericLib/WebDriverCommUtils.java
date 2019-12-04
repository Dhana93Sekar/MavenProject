package com.vTiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommUtils 
{
	static Select sel;
	static Alert alert;
	static public void threadSleep() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	static public void waitForPageToLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	static public void waitForElemnetPresent(WebElement element,WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	static public void waitForElementClickable(WebElement element,WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	static public void select(WebElement element , String data){
		sel = new Select(element);
		sel.selectByVisibleText(data);
	}
	static public void select(WebElement element , int index){
		sel = new Select(element);
		sel.selectByIndex(index);
	}
	static public void select(String value,WebElement element){
		sel = new Select(element);
		sel.selectByValue(value);
	}
	static public void moveMouse(WebElement element,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	static public void acceptAlert(WebDriver driver)
	{
		alert.accept();
	}
	static public void switchToAlert(WebDriver driver)
	{
		driver.switchTo().alert();
	}
	static public String getAlertText(WebDriver driver)
	{
		String text = alert.getText();
		return text;
	}
	static public void sendAlertText(WebDriver driver,String data)
	{
		alert.sendKeys(data);
	}
	
}
