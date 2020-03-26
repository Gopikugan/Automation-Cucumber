package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;

public class HomePage extends Base{
	
	
	public HomePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'zen-active') and @id='home_Tab']")
	private WebElement homePageIdentifier;
	
	@FindBy(how = How.XPATH, using = "//li[@id='Lead_Tab']")
	private WebElement leadTabIdentifier;
	
	@FindBy(how = How.XPATH, using = "//div[@class='globalHeaderBar']//a//span[contains(@class, 'avatar')]")
	private WebElement avatarIdentifier;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='zen-options']//li//a[contains(@title, 'Logout')]")
	private WebElement logoutIdentifier;
	
	
	
	public HomePage checkHomePage(){
		verifyDisplayed(homePageIdentifier);
		return this;
	}
	
	public LeadPage clickLeadTab() {
		click(leadTabIdentifier);
		return new LeadPage(driver, node, test);
	}
	
	public HomePage getHomePage() {
		return new HomePage(driver, node, test);
	}
	
	public LoginPage logout() {
		click(avatarIdentifier);
		click(logoutIdentifier);
		return new LoginPage(driver, node, test);
	}
	
	
	/*
	 * 
	 * 
	 * Functions related to Home page
	 * 
	 * 
	 * 
	 */
	
	
	public LeadPage getLeadPage() {
		return getHomePage().clickLeadTab();
	}
	
	
	
}
