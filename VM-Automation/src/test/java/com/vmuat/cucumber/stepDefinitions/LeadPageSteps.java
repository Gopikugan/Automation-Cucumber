package com.vmuat.cucumber.stepDefinitions;

import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.AccountsPage;
import com.vmuat.salesforce.CreateLeadPage;
import com.vmuat.salesforce.HomePage;
import com.vmuat.salesforce.LeadPage;
import com.vmuat.salesforce.LoginPage;

import io.cucumber.java.en.And;


public class LeadPageSteps{
	
	private TestContext testContext;
	private PageObjectManager pageObjectManager;
	private ConfigurationManager configurationManager;
	
	private HomePage homepage;
	private AccountsPage accountspage;
	private LeadPage leadpage;
	private CreateLeadPage createleadpage;
	
	public LeadPageSteps(TestContext context) {
		this.testContext = context;
		this.pageObjectManager = testContext.getPageObjectManager();
		this.configurationManager = testContext.getconfigurationManager();
		
		this.homepage = pageObjectManager.getHomePage();
		this.accountspage = pageObjectManager.getAccountsPage();
		this.leadpage = pageObjectManager.getLeadPage();
		this.createleadpage = pageObjectManager.getCreateLeadPage();
		
	}
	
	
	
	@And("User creates new lead")
	public void User_creates_new_lead() {
		leadpage =  homepage.getHomePage()
	    								.getLeadPage();
		
		createleadpage = leadpage.getCreateLeadPage();
		createleadpage = createleadpage.getCreateLeadPage()
						    				.checkCreateLeadPage()
											.setLeadDetails("SCCI", "1-4 - SO", "Broadband", "Yes", "BD Scotland", "BD - Midlands", "Qualified")
											.setCustomerDetails("Ms.", "First_name", "Last_name", "gopi@gmail.com", "07412541254")
											.setAddressDetails("Sheffield", "Hillsborough", "United Kingdom", "SG143dz")
											.saveLeadDetails();
	}	
	
	
	@And("User convert lead")
	public void User_convert_lead() {
		accountspage = createleadpage.getCreateLeadPage()
											.checkCreateLeadPage()
											.convertLead("Create New Account: SCCI")
											.getRefreshedAccountsPage();
	}
	
	
	
}
