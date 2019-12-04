package com.vTiger.CreateOrganizationTest;

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
public class CreateOrganization_Assign_IndustryTest extends BaseClass{

	@Test
	public void assignIndustryTest() throws Throwable
	{
		String org_Name = lib.getExcelData("sheet2", 28, 3);
		String industry = lib.getExcelData("sheet2", 28, 2);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 3: Click On Organization Link*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getOrganizationLink().click();

		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();
		Assert.assertEquals(expOrgPage, actOrgPage);
		Reporter.log("Organization page Displayed Successfully");

		/*Step 4: Click on Create Organization Button*/
		op.getCreateOrganizatinBtn().click();
		op.getOrganizationName().sendKeys(org_Name);
		WebDriverCommUtils.select(industry, op.getIndustry());
		
		op.getSaveBtn().click();
		String s1 = op.getSuccessmsg1().getText();
		String s2 = op.getSuccessmsg2().getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);
		Reporter.log("Organization created Successfully");
	}

}
