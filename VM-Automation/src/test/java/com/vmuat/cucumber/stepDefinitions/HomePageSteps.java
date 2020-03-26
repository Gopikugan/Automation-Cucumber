package com.vmuat.cucumber.stepDefinitions;

import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.HomePage;
import com.vmuat.salesforce.LoginPage;

import io.cucumber.java.en.And;

public class HomePageSteps {
	
	private TestContext testContext;
	private PageObjectManager pageObjectManager;
	private ConfigurationManager configurationManager;
	
	private LoginPage loginpage;
	private HomePage homepage;
	
	public HomePageSteps(TestContext context) {
		this.testContext = context;
		this.pageObjectManager = testContext.getPageObjectManager();
		this.configurationManager = testContext.getconfigurationManager();
		
		this.loginpage = pageObjectManager.getLoginPage();
		this.homepage = pageObjectManager.getHomePage();
	}
	
	@And("User logged out from salesforce")
	public void User_logged_out_from_salesforce() {
		loginpage = homepage.getHomePage().logout();	
	}
	
}
