package com.vmuat.cucumber.stepDefinitions;

import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.AccountsPage;
import com.vmuat.salesforce.HomePage;
import com.vmuat.salesforce.LoginPage;
import com.vmuat.salesforce.OppurtunityPage;

import io.cucumber.java.en.And;

public class AccountsPageSteps{
	
	private TestContext testContext;
	private PageObjectManager pageObjectManager;
	private ConfigurationManager configurationManager;
	
	private OppurtunityPage oppurtunityPage;
	private AccountsPage accountspage;
	
	public AccountsPageSteps(TestContext context) {
		this.testContext = context;
		this.pageObjectManager = testContext.getPageObjectManager();
		this.configurationManager = testContext.getconfigurationManager();
		
		this.oppurtunityPage = pageObjectManager.getOppurtunityPage();
		this.accountspage = pageObjectManager.getAccountsPage();
	}
	
	
	@And("User navigate to oppurtunity page")
	public void User_navigate_to_oppurtunity_page() {

		oppurtunityPage = accountspage.getAccountsPage()
												.getRefreshedAccountsPage()
												.getOppurtunityPage();
	}
	
}
