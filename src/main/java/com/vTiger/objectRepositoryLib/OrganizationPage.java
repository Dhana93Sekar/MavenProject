package com.vTiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Dhanashekhar
 *
 */
public class OrganizationPage
{
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizatinBtn;
	
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(xpath="//input[@type='button'][1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successmsg1;
	
	@FindBy(xpath="//span[@class='small']")
	private WebElement successmsg2;
	
	@FindBy(xpath="//option[@value='Accounts']")
	private WebElement qcOrganizationLink;
	
	@FindBy(id="qccombo")
	private WebElement qcLink;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement assignMember;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement assignToGroupRadioBtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement selectGroupId;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement assignToUserRadioBtn;
	
	@FindBy(name="assigned_user_id")
	private WebElement selectUserID;
	
	/**
	 * @return the assignToUserRadioBtn
	 */
	public WebElement getAssignToUserRadioBtn() {
		return assignToUserRadioBtn;
	}
	/**
	 * @return the selectUserID
	 */
	public WebElement getSelectUserID() {
		return selectUserID;
	}
	/**
	 * 
	 * @return the selectGroupId
	 */
	public WebElement getselectGroupId() {
		return selectGroupId;
	}
	/**
	 * 
	 * @return the assignToGroupRadioBtn
	 */
	public WebElement getAssignToGroupRadioBtn() {
		return assignToGroupRadioBtn;
	}
	/**
	 * 
	 * @return the assignMember
	 */
	public WebElement getAssignMember() {
		return assignMember;
	}
	/**
	 * 
	 * @return the industry
	 */
	public WebElement getIndustry() {
		return industry;
	}
	/**
	 * 
	 * @return the qcOrganizationLink
	 */
	public WebElement getQcOrganizationLink() {
		return qcOrganizationLink;
	}
	/**
	 * 
	 * @return the qcLink
	 */
	public WebElement getQcLink() {
		return qcLink;
	}

	/**
	 * @return the organizationLink
	 */
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	/**
	 * @return the createOrganizatinBtn
	 */
	public WebElement getCreateOrganizatinBtn() {
		return createOrganizatinBtn;
	}

	/**
	 * @return the organizationName
	 */
	public WebElement getOrganizationName() {
		return organizationName;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the successmsg1
	 */
	public WebElement getSuccessmsg1() {
		return successmsg1;
	}

	/**
	 * @return the successmsg2
	 */
	public WebElement getSuccessmsg2() {
		return successmsg2;
	}

	
}
