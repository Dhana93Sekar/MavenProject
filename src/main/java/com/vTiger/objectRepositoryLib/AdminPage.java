package com.vTiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Dhanashekhar
 *
 */
public class AdminPage 
{
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement settingsLink; 
	
	@FindBy(linkText="CRM Settings")
	private WebElement crmSettingsLink;
	
	@FindBy(xpath="//a[contains(text(),'Users')]")
	private WebElement usersLink;
	
	@FindBy(xpath="//input[@title='New User [Alt+N]']")
	private WebElement newUserBtn;
	
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement userPassword;
	
	@FindBy(name="email1")
	private WebElement userEmail;
	
	@FindBy(name="confirm_password")
	private WebElement userConfirmPassword;
	
	@FindBy(name="last_name")
	private WebElement userLastName;
	
	@FindBy(xpath="//input[@name='role_name']/following-sibling::a")
	private WebElement selectUserRole;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveBtn;

	/**
	 * @return the SettingsLink
	 */
	public WebElement getSettingsLink() {
		return settingsLink;
	}
	/**
	 * @return the cRMSettingsLink
	 */
	public WebElement getCRMSettingsLink() {
		return crmSettingsLink;
	}

	/**
	 * @return the usersLink
	 */
	public WebElement getUsersLink() {
		return usersLink;
	}

	/**
	 * @return the newUserBtn
	 */
	public WebElement getNewUserBtn() {
		return newUserBtn;
	}

	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return userName;
	}

	/**
	 * @return the userPassword
	 */
	public WebElement getUserPassword() {
		return userPassword;
	}

	/**
	 * @return the userEmail
	 */
	public WebElement getUserEmail() {
		return userEmail;
	}

	/**
	 * @return the userConfirmPassword
	 */
	public WebElement getUserConfirmPassword() {
		return userConfirmPassword;
	}

	/**
	 * @return the userLastName
	 */
	public WebElement getUserLastName() {
		return userLastName;
	}

	/**
	 * @return the selectUserRole
	 */
	public WebElement getSelectUserRole() {
		return selectUserRole;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
