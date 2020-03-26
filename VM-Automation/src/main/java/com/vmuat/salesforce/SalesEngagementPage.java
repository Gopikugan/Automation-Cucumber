package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.eventbus.DeadEvent;
import com.vmuat.apiBase.Base;

public class SalesEngagementPage extends Base{
	
	public SalesEngagementPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	
	@FindBy(how=How.XPATH, using = "//img[@class='pageTitleIcon' and @title='Sales Engagement']")
	private WebElement SalesEngagementPageIdentifier;
	
	@FindBy(how=How.XPATH, using = "//form//div[@id='ep']")
	private WebElement editSalesEngagementPageIdentifier;
	
	@FindBy(how=How.XPATH, using = "//form[contains(@action,'recordtypeselect')]//select")
	private WebElement selectRecordTypeIdentifier;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@class,'BottomButtons')]//input[@title='Continue']")
	private WebElement continueIdentifier;
	
	
	@FindBy(how=How.XPATH, using = "//img[contains(@title,'Commercial Manager Lookup')]")
	private WebElement commercialManagerLookupIdentifier;
	
	@FindBy(how=How.XPATH, using = "//frame[contains(@src,'LookupResultsFrame')]")
	private WebElement lookupIframeIdentifier;
	
	@FindBy(how=How.XPATH, using = "//tr[contains(@class, 'first')]//a[contains(@onclick,'editPage')]")
	private WebElement selectManagerIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'Sales Engagement Group')]/../following-sibling::td[1]//select")
	private WebElement salesEngagementGroupIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'Request Type')]/../following-sibling::td[1]//select")
	private WebElement requestTypeIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'Legal Engagement Date')]/../following-sibling::td[1]//a")
	private WebElement legalEngagementDateLinkIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),\"T's & C's\")]/../following-sibling::td[1]//select")
	private WebElement TCsIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'Term of Contract')]/../../following-sibling::td//input")
	private WebElement contractTremIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'Third Party Involvement')]/../../following-sibling::td//select")
	private WebElement thirdPartyinvolveIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'already sent to customer')]/../following-sibling::td//select")
	private WebElement documentSentToCustIdentifier;
	
	@FindBy(how=How.XPATH, using = "//label[contains(text(),'Relevant documents')]/../../following-sibling::td//input")
	private WebElement relevantDocumentIdentifier;
	
	@FindBy(how=How.XPATH, using = "//iframe[contains(@title, 'Rich Text Editor')]")
	private WebElement descriptionIframeIdentifier;
	
	@FindBy(how=How.XPATH, using = "/html/body[contains(@class, 'cke_editable')]")
	private WebElement descriptionIdentifier;
	
	@FindBy(how=How.XPATH, using = "//td[@id= 'bottomButtonRow']//input[@title= 'Save']")
	private WebElement saveBtnIdentifier;
	
	
	
	public SalesEngagementPage checkSalesEngagementPage(){
		verifyDisplayed(SalesEngagementPageIdentifier);
		return this;
	}
	public SalesEngagementPage checkEditSalesEngagementPage(){
		verifyDisplayed(editSalesEngagementPageIdentifier);
		return this;
	}
	public SalesEngagementPage selectRecordType(String recordType){
		selectDropDownUsingText(selectRecordTypeIdentifier, recordType);
		return this;
	}
	public SalesEngagementPage clickContinue() {
		click(continueIdentifier);
		return new SalesEngagementPage(driver, node, test);
	}
	public SalesEngagementPage selectommercialManager() {
		click(commercialManagerLookupIdentifier);
		String parent = getCurrentWindow();
		switchToWindow(1);
		switchToFrame(lookupIframeIdentifier);
		click(selectManagerIdentifier);
		switchToWindow(parent);
		defaultContent();
		return this;
	}
	
	public SalesEngagementPage selectsalesEngagementGroup(String salesGroup) {
		selectDropDownUsingText(salesEngagementGroupIdentifier, salesGroup);
		return this;
	}
	public SalesEngagementPage selectRequestType(String requestType) {
		selectDropDownUsingText(requestTypeIdentifier, requestType);
		return this;
	}
	public SalesEngagementPage selectLegalEngagementDateToday() {
		click(legalEngagementDateLinkIdentifier);
		return this;
	}
	public SalesEngagementPage selectTCs(String TCs) {
		selectDropDownUsingText(TCsIdentifier, TCs);
		return this;
	}
	public SalesEngagementPage selectThirdPartyInvolve(String thirdPaty) {
		selectDropDownUsingText(thirdPartyinvolveIdentifier, thirdPaty);
		return this;
	}
	public SalesEngagementPage enableRelevantDocument() {
		click(relevantDocumentIdentifier);
		return this;
	}
	public SalesEngagementPage selectDocumentSent(String documentSent) {
		selectDropDownUsingText(documentSentToCustIdentifier, documentSent);
		return this;
	}
	public SalesEngagementPage setContractTerm(String contractTerm) {
		clearAndType(contractTremIdentifier, contractTerm);
		return this;
	}
	public SalesEngagementPage setDescription(String description) {
		switchToFrame(descriptionIframeIdentifier);
		clearAndType(descriptionIdentifier, description);
		defaultContent();
		return this;
	}
	public SalesEngagementPage saveSalesEngagement() {
		click(saveBtnIdentifier);
		return this;
	}
	
	
	public SalesEngagementPage getRefreshedSalesEngagementPage() {
		return new SalesEngagementPage(driver, node, test);
	}
	public SalesEngagementPage getSalesEngagementPage() {
		return new SalesEngagementPage(driver, node, test);
	}
	
	
	public SalesEngagementPage getEditSalesEngagementPage(String recordType) {
		return getSalesEngagementPage().checkSalesEngagementPage()
								.selectRecordType(recordType)
								.clickContinue()
								.getRefreshedSalesEngagementPage();
	}
	public SalesEngagementPage getEditSalesEngagementPage() {
		return this;
	}
	
	
}
