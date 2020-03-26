package com.vmuat.cucumber.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.vmuat.manager.ConfigurationManager;
import com.vmuat.manager.PageObjectManager;
import com.vmuat.manager.TestContext;
import com.vmuat.salesforce.GenericFunction;
import com.vmuat.salesforce.OppurtunityPage;
import com.vmuat.salesforce.SalesEngagementPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesEngagementPageSteps{
	
	private TestContext testContext;
	private PageObjectManager pageObjectManager;
	private ConfigurationManager configurationManager;
	
	private SalesEngagementPage salesEngagementPage;
	private OppurtunityPage oppurtunityPage;
	
	public SalesEngagementPageSteps(TestContext testContext) {
		this.testContext = testContext;
		this.pageObjectManager = testContext.getPageObjectManager();
		this.configurationManager = testContext.getconfigurationManager();
	}
	
	
	
	
	
	
	@When("User select below record Type for sales engagement")
	public void User_select_below_record_Type_for_sales_engagement(DataTable data) {
		List<Map<String, String>> list = data.asMaps(String.class, String.class);
		salesEngagementPage = salesEngagementPage.getSalesEngagementPage()
								.checkSalesEngagementPage()
								.getEditSalesEngagementPage(list.get(0).get("Record Type"));
	}
	
	@Then("Below Sales Engagement Group and Request Type combination should be available for user to select")
	public void Below_Sales_Engagement_Group_and_Request_Type_combination_should_be_available_for_user_to_select(DataTable data) {
		List<Map<String, String>> list = data.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			System.out.println("|engagementGroup = " + list.get(i).get("Sales Engagement Group") + " | requestType = " + list.get(i).get("Request Type").replace("?", "–") + "|" );				
			salesEngagementPage = salesEngagementPage.getEditSalesEngagementPage()
									.checkEditSalesEngagementPage()
									.selectsalesEngagementGroup(list.get(i).get("Sales Engagement Group"))
									.selectRequestType(list.get(i).get("Request Type").replace("?", "–"));
		}		
	}
	
	
	@And("User creates sales engagement with below options")
	public void User_creates_sales_engagement_with_below_options(DataTable data) {
		List<Map<String, String>> list = data.asMaps(String.class, String.class);
		salesEngagementPage = salesEngagementPage.getEditSalesEngagementPage()
								.checkEditSalesEngagementPage()
								.selectsalesEngagementGroup(list.get(0).get("Sales Engagement Group"))
								.selectRequestType(list.get(0).get("Request Type").replace("?", "–"));
		salesEngagementPage = salesEngagementPage.selectommercialManager()
								.selectLegalEngagementDateToday()
								.setContractTerm("12")
								.selectTCs("NDA")
								.selectThirdPartyInvolve("Yes")
								.selectDocumentSent("Yes")
								.enableRelevantDocument();
		
		salesEngagementPage = salesEngagementPage.setDescription("Test description")
								.saveSalesEngagement()
								.getRefreshedSalesEngagementPage();
		
		new GenericFunction().closeApplication();
		

	}
	
	
	
	
	
	@Given("User able to choose Sales Engagement Group and Request Type")
	public void user_able_to_choose_Sales_Engagement_Group_and_Request_Type() {
		System.out.println("insdie the step");
	}
	
	
	
	
}
