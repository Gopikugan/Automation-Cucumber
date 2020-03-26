package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;

public class OppurtunityPage extends Base{
	
	public OppurtunityPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//img[@title='Opportunity' and @class='pageTitleIcon']")
	private WebElement opportunityPageIdentifier;
	
	@FindBy(how=How.XPATH, using = "//img[@title='Opportunity' and @class='pageTitleIcon']")
	private WebElement opportunityIdIdentifier;
	
	@FindBy(how=How.XPATH, using = "//input[@value='New Sales Engagement']")
	private WebElement newSalesEngagementIdentifier;
	
	public OppurtunityPage checkOppurtunityPage(){
		verifyDisplayed(opportunityPageIdentifier);
		return this;
	}
	public String getOpportunityId(){
		return getElementText(opportunityIdIdentifier);
	}
	public SalesEngagementPage clickNewSalesEngagement() {
		click(newSalesEngagementIdentifier);
		return new SalesEngagementPage(driver, node, test);
	}
	
	
	
	
	
	public OppurtunityPage getOppurtunityPage() {
		return new OppurtunityPage(driver, node, test);
	}
	public SalesEngagementPage getSalesEngagementPage() {
		return getOppurtunityPage().checkOppurtunityPage()
								.clickNewSalesEngagement();
	}
	
	
	
	
	
	
}
