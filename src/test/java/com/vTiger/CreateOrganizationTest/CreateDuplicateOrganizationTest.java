package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.OrganizationPage;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateDuplicateOrganizationTest extends BaseClass
{
	@Test
	public  void cretaeDuplicate_OrgTest() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 7, 2);
		String org_Duplicate = lib.getExcelData("Sheet2", 7, 3);
		String exp_alert = lib.getExcelData("Sheet2", 7, 4);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/* Step 3:Click on Organization */
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getOrganizationLink();

		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();
		System.out.println(expOrgPage);
		System.out.println(actOrgPage);
		Assert.assertEquals(expOrgPage, actOrgPage);
		Reporter.log("Organization Page Displayed Successfully");

		/*Step 4: CLick on Create Organization Link*/
		op.getCreateOrganizatinBtn().click();

		/*Step 5: Enter the Organization Name and Save it*/
		op.getOrganizationName().sendKeys(org_Duplicate);
		op.getSaveBtn().click();

		/*Step 6: Click on Create Organization*/
		while(true)
		{
			try 
			{
				op.getCreateOrganizatinBtn().click();
				break;
			}
			catch(Exception e)
			{

			}
		}
		/*Step 7: Enter Duplicate Organization Name and Save it*/
		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();

		/*Step 8: Handle the Alert Pop-Up */
		while(true)
		{
			try 
			{
				WebDriverCommUtils.switchToAlert(driver);
				break;
			}
			catch(Exception e)
			{

			}
		}
		String act_Alert = WebDriverCommUtils.getAlertText(driver);
		System.out.println(act_Alert);
		WebDriverCommUtils.acceptAlert(driver);
		lib.setExcelData("Sheet2", 7, 5	,act_Alert);
		Assert.assertEquals(exp_alert, act_Alert);
		Reporter.log("Alert Message Handled");
	}
}
