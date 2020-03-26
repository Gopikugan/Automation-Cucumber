package com.vmuat.salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vmuat.apiBase.Base;


public class CreateLeadPage extends Base{
	
	public CreateLeadPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(how=How.XPATH, using = "//li[contains(@class, 'zen-active') and @id ='Lead_Tab']")
	private WebElement CreateLeadPageIdentifier;
	
	@FindBy(how = How.CLASS_NAME, using = "lookupIcon")
	private WebElement campaignLookupIdentifier;
	
	@FindBy(how = How.XPATH, using = "//frame[contains(@src,'LookupResults')]")
	private WebElement Lookup_frameIdentifier;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@onclick,'editPage')][1]")
	private WebElement Campaign_selectIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Company')]/../following-sibling::td[1]//input")
	private WebElement CompanyIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'No. of Employees')]/../following-sibling::td[1]//select")
	private WebElement No_Of_EmployeesIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Salutation')]/../following-sibling::td[1]//select")
	private WebElement SalutationsIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'First Name')]/../following-sibling::td[1]//input")
	private WebElement First_nameIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Last Name')]/../following-sibling::td[1]//input")
	private WebElement Last_nameIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Primary Product Interest')]/../following-sibling::td[1]//select")
	private WebElement Primary_Product_interestIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'New Service for Customer')]/../../following-sibling::td//select")
	private WebElement New_Service_customerIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Lead Source')]/ancestor::td/following-sibling::td[1]//select")
	private WebElement Lead_sourceIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Lead Origin')]/ancestor::td/following-sibling::td[1]//select")
	private WebElement Lead_originIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Street')]/ancestor::td/following-sibling::td[1]//textarea")
	private WebElement StreetIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Email')]/ancestor::td/following-sibling::td[1]//input")
	private WebElement EmailIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Telephone')]/ancestor::td/following-sibling::td[1]//input")
	private WebElement TelephoneIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'City')]/ancestor::td/following-sibling::td[1]//input")
	private WebElement cityIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Postal Code')]/ancestor::td/following-sibling::td[1]//input")
	private WebElement Postal_codeIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Country')]/ancestor::td/following-sibling::td[1]//input")
	private WebElement CountryIdentifier;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Lead Status')]/ancestor::td/following-sibling::td[1]//select")
	private WebElement Lead_StatusIdentifier;

	@FindBy(how = How.XPATH, using = "//input[@name='save']")
	private WebElement SaveBtnIdentifier;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pbHeader')]//input[@value='Convert']")
	private WebElement ConvertIdentifier;
	
	@FindBy(how=How.XPATH, using = "//form[contains(@action,'leadconvert')]")
	private WebElement convertLeadPageIdentifier;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@title,'Account Name')]")
	private WebElement selectAccountNameIdentifier;
	
	@FindBy(how = How.XPATH, using = "//form[contains(@action,'leadconvert')]//div[@class='pbHeader']//input[@value='Convert']")
	private WebElement ConfirmConvertIdentifier;
	
	/*
	 * @FindBy(how=How.XPATH, using =
	 * "//form[contains(@action,'LG_LeadConversion')]") private WebElement
	 * LeadConversionIdentifier;
	 */
	
	
	
	
	public CreateLeadPage checkCreateLeadPage(){
		verifyDisplayed(CreateLeadPageIdentifier);
		return this;
	}
	public CreateLeadPage selectCampaign() {
		click(campaignLookupIdentifier);
		String parent = getCurrentWindow();
		switchToWindow(1);
		switchToFrame(Lookup_frameIdentifier);
		click(Campaign_selectIdentifier);
		switchToWindow(parent);
		defaultContent();
		return this;
	}
	public CreateLeadPage enterCompanyName(String companyName){
		clearAndType(CompanyIdentifier, companyName);
		return this;
	}
	public CreateLeadPage selectNo_Of_Employees(String NoOfEmp){
		selectDropDownUsingText(No_Of_EmployeesIdentifier, NoOfEmp);
		return this;
	}
	public CreateLeadPage selectSalutations(String salutation){
		selectDropDownUsingText(SalutationsIdentifier, salutation);
		return this;
	}
	public CreateLeadPage enterFirstName(String firstname){
		clearAndType(First_nameIdentifier, firstname);
		return this;
	}
	public CreateLeadPage enterLatName(String lastname){
		clearAndType(Last_nameIdentifier, lastname);
		return this;
	}
	public CreateLeadPage selectPrimaryProductIntrest(String productIntrest){
		selectDropDownUsingText(Primary_Product_interestIdentifier, productIntrest);
		return this;
	}
	public CreateLeadPage selectNewServiceCustomer(String newService){
		selectDropDownUsingText(New_Service_customerIdentifier, newService);
		return this;
	}
	public CreateLeadPage selectLead_source(String leadSource){
		selectDropDownUsingText(Lead_sourceIdentifier, leadSource);
		return this;
	}
	public CreateLeadPage selectLead_origin(String leadOrgin){
		selectDropDownUsingText(Lead_originIdentifier, leadOrgin);
		return this;
	}
	public CreateLeadPage enterEmail(String emailid){
		clearAndType(EmailIdentifier, emailid);
		return this;
	}
	public CreateLeadPage enterTelephone(String telephone){
		clearAndType(TelephoneIdentifier, telephone);
		return this;
	}
	public CreateLeadPage enterStreet(String street){
		clearAndType(StreetIdentifier, street);
		return this;
	}
	public CreateLeadPage enterCity(String city){
		clearAndType(cityIdentifier, city);
		return this;
	}
	public CreateLeadPage enterpostCode(String postcode){
		clearAndType(Postal_codeIdentifier, postcode);
		return this;
	}
	public CreateLeadPage entercountry(String country){
		clearAndType(CountryIdentifier, country);
		return this;
	}
	public CreateLeadPage selectLeadStatus(String leadStatus){
		selectDropDownUsingText(Lead_StatusIdentifier, leadStatus);
		return this;
	}
	public CreateLeadPage clickSave() {
		click(SaveBtnIdentifier);
		return this;
	}
	public CreateLeadPage clickConvert() {
		click(ConvertIdentifier);
		return this;
	}
	public CreateLeadPage checkCofirmLeadScreen() {
		verifyDisplayed(convertLeadPageIdentifier);
		return this;
	}
	public CreateLeadPage selectAccountName(String AccountName){
		selectDropDownUsingText(selectAccountNameIdentifier, AccountName);
		return this;
	}
	public AccountsPage clickConfirmConvert() {
		click(ConfirmConvertIdentifier);
		return new AccountsPage(driver, node, test);
	}
	
	
	/*
	 * public CreateLeadPage checkLeadConversionScreen() {
	 * verifyDisplayed(ConvertIdentifier); return this; }
	 */

	
	/*
	 * public OppurtunityPage ConvertToOppurtunity() {
	 * click(LeadConversionIdentifier); return new OppurtunityPage(driver, node,
	 * test); }
	 */
	
	
	
	public CreateLeadPage getCreateLeadPage() {
		return new CreateLeadPage(driver, node, test);
	}
	
	public CreateLeadPage getRefreshedCreateLeadPage() {
		return new CreateLeadPage(driver, node, test);
	}
	
	

	/*
	 * 
	 * 
	 * 
	 * Functions related to Create lead page
	 * 
	 * 
	 * 
	 */
	
	
	
	
	/*
	 * To fill Lead details 
	 * */
	public CreateLeadPage setLeadDetails(String companyName, String NoOfEmp, String productIntrest, String newService, 
			String leadSource, String leadOrgin, String leadStatus) {
		return getCreateLeadPage().checkCreateLeadPage()
				.selectCampaign()
				.enterCompanyName(companyName)
				.selectNo_Of_Employees(NoOfEmp)
				.selectPrimaryProductIntrest(productIntrest)
				.selectNewServiceCustomer(newService)
				.selectLead_source(leadSource)
				.selectLead_origin(leadOrgin)
				.selectLeadStatus(leadStatus);
				
	}
	

	/*
	 * To fill customer details
	 * */
	public CreateLeadPage setCustomerDetails(String salutation, String firstname, String lastname, String emailid, String telephone) {
		return getCreateLeadPage().checkCreateLeadPage()
				.selectSalutations(salutation)
				.enterFirstName(firstname)
				.enterLatName(lastname)
				.enterEmail(emailid)
				.enterTelephone(telephone);
	}
	
	

	/*
	 * To fill address details
	 * */
	public CreateLeadPage setAddressDetails(String street, String city, String country, String postalCode) {
		return getCreateLeadPage().checkCreateLeadPage()
				.enterStreet(street)
				.enterCity(city)
				.entercountry(country)
				.enterpostCode(postalCode);
	}
	
	

	/*
	 * To Save Lead details
	 * */
	public  CreateLeadPage saveLeadDetails() {
		return getCreateLeadPage().checkCreateLeadPage()
								.clickSave();
	}
	
	
	
	/*
	 * To convert Lead to accounts ans oppurtunity and landing on accounts page
	 * */
	public AccountsPage convertLead(String AccountName) {
		return getCreateLeadPage().checkCreateLeadPage()
							.clickConvert()
							.getRefreshedCreateLeadPage()
							.checkCofirmLeadScreen()
							.selectAccountName(AccountName)
							.clickConfirmConvert();
	}
	
	

	/*
	 * To convert leadto accounts and oppurtunity and lands on oppurtunity page
	 * */
	/*
	 * public OppurtunityPage getOppurtunityPage() { return
	 * getCreateLeadPage().checkLeadConversionScreen() .clickConvert()
	 * .checkLeadCofirmScreen() .ConvertToOppurtunity(); }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
}
