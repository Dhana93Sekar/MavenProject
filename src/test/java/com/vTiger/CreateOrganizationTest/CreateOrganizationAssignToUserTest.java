package com.vTiger.CreateOrganizationTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.AdminPage;
import com.vTiger.objectRepositoryLib.OrganizationPage;
/**
 * @author Dhanashekhar
 */

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationAssignToUserTest extends BaseClass
{
	@Test
	public void assignUser() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 19, 3);
		String user_Name = lib.getExcelData("Sheet2", 19, 2);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		
		AdminPage ad = PageFactory.initElements(driver, AdminPage.class);
		ad.getSettingsLink().click();
		ad.getCRMSettingsLink().click();
		ad.getUsersLink().click();
		ad.getNewUserBtn().click();
		ad.getUserName().sendKeys("Dhana");
		ad.getUserPassword().sendKeys("Dhana");
		ad.getUserEmail().sendKeys("Dhana@gmail.com");
		ad.getUserConfirmPassword().sendKeys("Dhana");
		ad.getUserLastName().sendKeys(user_Name);
		ad.getSelectUserRole().click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String pid = it.next();
		String cid = it.next();
		driver.switchTo().window(cid);
		driver.findElement(By.linkText("Sales Man")).click();
		driver.switchTo().window(pid);
		ad.getSaveBtn().click();
		
		String usertext = driver.findElement(By.xpath("//b//a[contains(text(),'Dhana')]")).getText();
		if(usertext.contains(user_Name))
		{
			System.out.println("User created successfully");
		}
		
		/* Step 3: Click on Organization Tab*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		while(true)
		{
			try
			{
				op.getOrganizationLink().click();
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();
		Assert.assertEquals(expOrgPage, actOrgPage);
		
		/*Step 4: Create Organization*/
		op.getCreateOrganizatinBtn().click();
		op.getOrganizationName().sendKeys(org_Name);
		
		/*Step 5:Assign User*/
		WebDriverCommUtils.select(op.getSelectUserID(), user_Name);
		op.getSaveBtn().click();

		String s1 = op.getSuccessmsg1().getText();
		String s2 = op.getSuccessmsg2().getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);
		
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

		lib.setExcelData("Sheet2", 19, 5, success_msg);
		Reporter.log("Organization Created Successfully");
	}
}
