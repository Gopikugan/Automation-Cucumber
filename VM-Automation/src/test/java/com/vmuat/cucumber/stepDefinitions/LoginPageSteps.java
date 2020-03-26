package com.vmuat.cucumber.stepDefinitions;


import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.GenericFunction;
import com.vmuat.salesforce.HomePage;
import com.vmuat.salesforce.LoginPage;

import io.cucumber.java.en.Given;

public class LoginPageSteps{
	
	private TestContext testContext;
	private PageObjectManager pageObjectManager;
	private ConfigurationManager configurationManager;
	
	private LoginPage loginpage;
	private HomePage homepage;
	
	public LoginPageSteps(TestContext  context) {
		this.testContext = context;
		this.pageObjectManager = testContext.getPageObjectManager();
		this.configurationManager = testContext.getconfigurationManager();
		
		this.loginpage = pageObjectManager.getLoginPage();
		this.homepage = pageObjectManager.getHomePage();
	}
	
	@Given("User logged to salesforce with username and password")
	public void user_logged_to_salesforce_with_username_and_password() {
		
	
		loginpage = new GenericFunction().startApplication("https://test.salesforce.com/")
										.getLoginPage();
		
		homepage =  loginpage.getLoginPage()
										.setLoginDetails("suganthi.kuppuraj@salesdesk.co.uk.uat","Password!01")
										.getHomePage();
	}

	
	
	
}
