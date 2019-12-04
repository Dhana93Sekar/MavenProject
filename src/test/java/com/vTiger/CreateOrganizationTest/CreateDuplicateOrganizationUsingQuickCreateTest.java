package com.vTiger.CreateOrganizationTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.OrganizationPage;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateDuplicateOrganizationUsingQuickCreateTest extends BaseClass 
{
	@Test
	public void qc_Duplicate_Organization() throws Throwable 
	{
		String org_Name = lib.getExcelData("sheet2", 13, 3);
		WebDriverCommUtils.waitForPageToLoad(driver);

		/*Step 3: Click on Quick Create Options*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getQcLink().click();
		op.getQcOrganizationLink().click();

		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();
		String s1 = op.getSuccessmsg1().getText();
		String s2 = op.getSuccessmsg2().getText();
		String msg = s1 + s2;
		System.out.println(msg);

		op.getQcLink().click();
		op.getQcOrganizationLink().click();

		WebDriverCommUtils.waitForElementClickable(op.getOrganizationName(), driver);
		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();

		while(true)
		{
			try
			{
				WebDriverCommUtils.switchToAlert(driver);
				break;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		String act_Text = WebDriverCommUtils.getAlertText(driver);
		System.out.println(act_Text);
		WebDriverCommUtils.acceptAlert(driver);
		lib.setExcelData("Sheet2", 4, 5, act_Text);
		String exp_Text = lib.getExcelData("Sheet2", 13, 4);
		Assert.assertEquals(exp_Text, act_Text);
		Reporter.log("Alert Handled Successfully");
	}
}

