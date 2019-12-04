package com.vTiger.CreateOrganizationTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.OrganizationPage;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationUsingQuickCreate extends BaseClass
{
	@Test
	public void qc_OrganizationCreate() throws Throwable 
	{
		String org_Name = lib.getExcelData("sheet2", 10, 3);
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 3: Create Organization Using Quick Create Link*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getQcLink().click();
		op.getQcOrganizationLink().click();
		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();
		String s1 = op.getSuccessmsg1().getText();
		String s2 = op.getSuccessmsg2().getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 10, 5, success_msg);
		
		Reporter.log("Organization Created Successfully");
	}
}
