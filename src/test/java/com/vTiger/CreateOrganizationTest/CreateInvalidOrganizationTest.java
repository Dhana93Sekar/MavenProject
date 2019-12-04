package com.vTiger.CreateOrganizationTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.OrganizationPage;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateInvalidOrganizationTest extends BaseClass
{
	@Test
	public void create_Invalid_OrganizationTest() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 4, 3);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 3: Click on Organization Link*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getOrganizationLink().click();
		String expOrgPage = lib.getPropertyKeyValue("organizationPage");
		String actOrgPage =driver.getTitle();
		Assert.assertEquals(expOrgPage, actOrgPage);
		
		/*Step 4: Click on Create Organization Button*/
		op.getCreateOrganizatinBtn().click();
		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();
		
		/*Step 5: Check Alert PopUp*/
		Alert alert = null;
		while(true)
		{
			try
			{
				alert = driver.switchTo().alert();
				break;
			}
			catch(Exception e)
			{

			}
		}
		
		String act_Text = alert.getText();
		System.out.println(act_Text);
		alert.accept();
		lib.setExcelData("Sheet2", 4, 5, act_Text);
		String exp_Text = lib.getExcelData("Sheet2", 4, 4);
		Assert.assertEquals(exp_Text, act_Text);
	}
}
