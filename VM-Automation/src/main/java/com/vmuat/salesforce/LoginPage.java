package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;



public class LoginPage extends Base{
	
	public LoginPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//form[@id='login_form']")			private WebElement loginPageIdentifier;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'username')]")	private WebElement usernameIdentifier;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")				private WebElement passwordIdentifier;
	@FindBy(how = How.XPATH, using = "//input[@id='Login']")				private WebElement loginbuttonIdentifier;
	
	public LoginPage checkLoginPage(){
		verifyDisplayed(loginPageIdentifier);
		return this;
	}
	
	public LoginPage enterUserName(String username){
		clearAndType(usernameIdentifier, username);
		return this;
	}

	public LoginPage enterPassword(String password){
		clearAndType(passwordIdentifier, password);
		return this;
	}
	public HomePage clickLogin() {
		click(loginbuttonIdentifier);
		return new HomePage(driver, node, test);		
	}
	public LoginPage getLoginPage() {
		return new LoginPage(driver, node, test);
	}
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * Login related functions
	 * 
	 * 
	 */
	
	
	public LoginPage setLoginDetails(String uname, String pwd){
		return getLoginPage()
				.checkLoginPage()
				.enterUserName(uname)
				.enterPassword(pwd);
	}
	
	public HomePage getHomePage() {
		return getLoginPage()
				.clickLogin();
	}
	
	
	
	
	
	
}	
