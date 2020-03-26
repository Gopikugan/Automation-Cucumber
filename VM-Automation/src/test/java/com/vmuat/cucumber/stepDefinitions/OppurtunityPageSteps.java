package com.vmuat.cucumber.stepDefinitions;

import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.OppurtunityPage;
import com.vmuat.salesforce.SalesEngagementPage;

import io.cucumber.java.en.And;

public class OppurtunityPageSteps{
	
	private TestContext testContext;
	private PageObjectManager pageObjectManager;
	private ConfigurationManager configurationManager;
	
	private SalesEngagementPage salesEngagementPage;
	private OppurtunityPage oppurtunityPage;
	
	public OppurtunityPageSteps(TestContext context) {
		this.testContext = context;
		this.pageObjectManager = testContext.getPageObjectManager();
		this.configurationManager = testContext.getconfigurationManager();
		
		this.oppurtunityPage = pageObjectManager.getOppurtunityPage();
		this.salesEngagementPage = pageObjectManager.getSalesEngagementPage();
	}
	
	
	@And("User navigates to new sales engagement page")
	public void User_navigates_to_new_sales_engagement_page() {
		salesEngagementPage = oppurtunityPage.checkOppurtunityPage()
				.getSalesEngagementPage();
	}
	
	
	
	
}
