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
public class CreateOrganizationAssignToGroupTest extends BaseClass {

	@Test
	public void assignTOGroupTest() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 22, 3);
		String groupId = lib.getExcelData("Sheet2", 22, 2);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 3: Click on Organization Link*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getOrganizationLink().click();
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();

		Assert.assertEquals(expOrgPage, actOrgPage);
		
		/*Step 4: Create Organization*/
		op.getCreateOrganizatinBtn().click();
		op.getOrganizationName().sendKeys(org_Name);
		
		/*Step 5: Select Group to Assign */
		op.getAssignToGroupRadioBtn().click();
		WebDriverCommUtils.select(op.getselectGroupId(),groupId);
		op.getSaveBtn().click();
		
		String s1 = op.getSuccessmsg1().getText();
		String s2 = op.getSuccessmsg2().getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 22, 5, success_msg);
		
		Reporter.log("Organization Created Successfully");
	}

}
