package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;

public class Lead_AddressSearchPage extends Base{
	
	public Lead_AddressSearchPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//form[contains(@action, 'SearchPostcode')]")
	private WebElement lead_addressPageIdentifier;
	
	@FindBy(how = How.XPATH, using = "(//form[contains(@action, 'SearchPostcode')]//input[@type='text'])[1]")
	private WebElement companyNameIdentifier;
	
	@FindBy(how = How.XPATH, using = "(//form[contains(@action, 'SearchPostcode')]//input[@type='text'])[2]")
	private WebElement postcodeIdentifier;
	
	@FindBy(how = How.XPATH, using = "(//form[contains(@action, 'SearchPostcode')]//input[@type='submit'])")
	private WebElement searchBtnIdentifier;
	
	@FindBy(how = How.XPATH, using = "(//form[contains(@action, 'AddressSelection')])")
	private WebElement lead_addressSelectionPageIdentifier;
	
	@FindBy(how=How.XPATH, using = "(//form[contains(@action, 'AddressSelection')]//select)")
	private WebElement addressDropdownIdentifier;
	
	@FindBy(how = How.XPATH, using = "(//form[contains(@action, 'SearchPostcode')]//input[@type='submit'])")
	private WebElement nextBtnIdentifier;
	
	
	
	public Lead_AddressSearchPage checkLeadAddressPage(){
		verifyDisplayed(lead_addressPageIdentifier);
		return this;
	}
	
	public Lead_AddressSearchPage entercompanyName(String companyName){
		clearAndType(companyNameIdentifier, companyName);
		return this;
	}

	public Lead_AddressSearchPage enterPostcode(String postcode){
		clearAndType(postcodeIdentifier, postcode);
		return this;
	}
	public Lead_AddressSearchPage clickSearch() {
		click(searchBtnIdentifier);
		return this;		
	}
	
	public Lead_AddressSearchPage checkLeadAddressSelectionxPage(){
		verifyDisplayed(lead_addressSelectionPageIdentifier);
		return this;
	}
	
	public Lead_AddressSearchPage selectAddress(String visibleAddressText){
		selectDropDownUsingText(addressDropdownIdentifier, visibleAddressText);
		return this;
	}
	
	
	public CreateLeadPage clickNext() {
		click(nextBtnIdentifier);
		return new CreateLeadPage(driver, node, test);		
	}
	
	
	
	public Lead_AddressSearchPage getLeadAddressSearchPage() {
		return new Lead_AddressSearchPage(driver, node, test);
	}
	
	
	
	/*
	 * 
	 * 
	 * 
	 * Functions related to lead Address search page
	 * 
	 * 
	 * 
	 */
	
	
	
	/*
	 * Search Address
	 * */
	public Lead_AddressSearchPage setAddress(String companyName, String postcode, String visibleAddressText) {
		return getLeadAddressSearchPage().checkLeadAddressPage()
				.entercompanyName(companyName)
				.enterPostcode(postcode)
				.clickSearch()
				.checkLeadAddressSelectionxPage()
				.selectAddress(visibleAddressText);
	}
	
	
	public CreateLeadPage getCreateLeadPage() {
		return getLeadAddressSearchPage().checkLeadAddressSelectionxPage()
				.clickNext();
	}
	
	
	
	
	
	
}
