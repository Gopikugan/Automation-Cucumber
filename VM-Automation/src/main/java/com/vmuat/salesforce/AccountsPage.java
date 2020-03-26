package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;

public class AccountsPage extends Base{
	
	public AccountsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'zen-active') and @id='Account_Tab']")
	private WebElement accountsPageIdentifier;  
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'opportunityBlock')]//table//tr[2]//th//a")
	private WebElement oppurtunityIdentifier;

	public AccountsPage checkAccountsPage(){
		verifyDisplayed(accountsPageIdentifier);
		return this;
	}
	
	public OppurtunityPage clickOppurtunity() {
		click(oppurtunityIdentifier);
		return new OppurtunityPage(driver, node, test);
	}
	
	public AccountsPage getAccountsPage() {
		return new AccountsPage(driver, node, test);
	}
	
	public AccountsPage getRefreshedAccountsPage() {
		return new AccountsPage(driver, node, test);
	}
	
	public OppurtunityPage getOppurtunityPage() {
		return getAccountsPage()
				.clickOppurtunity();
	}
	
	
	
}
