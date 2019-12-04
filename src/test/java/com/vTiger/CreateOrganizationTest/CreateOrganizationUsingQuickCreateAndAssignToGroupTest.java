package com.vTiger.CreateOrganizationTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.OrganizationPage;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationUsingQuickCreateAndAssignToGroupTest extends BaseClass
{
	@Test
	public void qc_GroupAssign() throws Throwable
	{
	
		String org_Name = lib.getExcelData("sheet2", 16, 3);
		String groupId = lib.getExcelData("Sheet2", 16, 2);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 3: Click on Quick Create Link*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getQcLink().click();
		op.getQcOrganizationLink().click();
		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();
		
		
		/*Step 4: Assign Group to Organization*/
		WebDriverCommUtils.select(op.getAssignToGroupRadioBtn(), groupId);
		op.getSaveBtn();
		String s1 = op.getSuccessmsg1().getText();
		String s2 = op.getSuccessmsg2().getText();
		String msg = s1 + s2;
		System.out.println(msg);
		
		lib.setExcelData("Sheet2", 16, 5, msg);
		Reporter.log("Organization Created Successfully");
	}

}
