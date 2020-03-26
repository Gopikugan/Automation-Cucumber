package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;

public class LeadPage extends Base{
	
	public LeadPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//img[@title='Lead' and @class='pageTitleIcon']")
	private WebElement leadPageIdentifier;
	
	@FindBy(how = How.XPATH, using = "//input[@title='New' and @class='btn']")
	private WebElement newLeadIdentifier;
	
	public LeadPage checkLeadPage(){
		verifyDisplayed(leadPageIdentifier);
		return this;
	}
	
	public Lead_AddressSearchPage clickNewLead_GotoLeadAddressSearch() {
		click(newLeadIdentifier);
		return new Lead_AddressSearchPage(driver, node, test);
	}
	public CreateLeadPage clickNewLead_GotoLeadForm() {
		click(newLeadIdentifier);
		return new CreateLeadPage(driver, node, test);
	}
	
	public LeadPage getLeadPage() {
		return new LeadPage(driver, node, test);
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * Functions related to lead page
	 * 
	 * 
	 * 
	 */
	
	
	
	/*
	 * Go to address search page before getting details
	 * */
	public Lead_AddressSearchPage getLeadAddressSearchForm() {
		return getLeadPage().checkLeadPage()
						.clickNewLead_GotoLeadAddressSearch();
	}
	
	
	/*
	 * Go to address search page before getting details
	 * */
	public CreateLeadPage getCreateLeadPage() {
		return getLeadPage().checkLeadPage()
						.clickNewLead_GotoLeadForm();
	}
	
	
	
	
	
	
	
	
}
