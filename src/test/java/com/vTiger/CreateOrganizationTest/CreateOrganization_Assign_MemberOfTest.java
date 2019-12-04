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
import com.vTiger.objectRepositoryLib.OrganizationPage;

/**
 * @author Dhanashekhar
 *
 */

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganization_Assign_MemberOfTest extends BaseClass
{
	static String s1;
	static String s2;
	static String msg;
	@Test
	public void assignMember() throws Throwable 
	{
		String child_Org  = lib.getExcelData("Sheet2", 25, 3);
		System.out.println(child_Org);
		String parent_Org = lib.getExcelData("Sheet2", 25, 2);
		System.out.println(parent_Org);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 1: Click On Organization Link*/
		
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getOrganizationLink();
		WebDriverCommUtils.threadSleep();
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();

		Assert.assertEquals(expOrgPage, actOrgPage);

		op.getCreateOrganizatinBtn().click();
		op.getOrganizationName().sendKeys(parent_Org);
		op.getSaveBtn().click();
		
		s1 = op.getSuccessmsg1().getText();
		s2 = op.getSuccessmsg2().getText();
		msg = s1+s2;
		System.out.println("Organization creation msg:"+msg);
		
		op.getCreateOrganizatinBtn().click();
		op.getCreateOrganizatinBtn().sendKeys(child_Org);
		
		op.getAssignMember().click();
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String pid = it.next();
		String cid = it.next();
		driver.switchTo().window(cid);
		
		driver.findElement(By.xpath("//a[contains(text(),'"+parent_Org+"')]")).click();
		WebDriverCommUtils.switchToAlert(driver);
		WebDriverCommUtils.acceptAlert(driver);
		driver.switchTo().window(pid);
		
		op.getSaveBtn().click();
		s1 = op.getSuccessmsg1().getText();
		s2 = op.getSuccessmsg2().getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 25, 5, success_msg);
		Reporter.log("Organization Created Successfully");
	}
}
