package com.vmuat.cucumber.stepDefinitions;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
	
	
	
	@Given("User logged to salesforce Application with username and password")
	public void user_logged_to_salesforce_Application_with_username_and_password() {
		System.out.println("-->Function for " + "User logged to salesforce Application with username and password".toUpperCase());
	    System.out.println("BACKGROUND: User logged to salesforce Application with username and password " + "Passed");
	}

	@Given("User create new lead")
	public void user_create_new_lead() {
		System.out.println("-->Function for " + "User create new lead".toUpperCase());
		System.out.println("BACKGROUND: User create new lead " + "Passed"); 
	}

	@Given("User convert this lead")
	public void user_convert_this_lead() {
		System.out.println("-->Function for " + "User convert this lead".toUpperCase());
		System.out.println("User convert this lead " + "Passed");
	}


	@Given("User navigates to oppurtunity page")
	public void user_navigates_to_oppurtunity_page() {
		System.out.println("-->Function for " + "User navigates to oppurtunity page".toUpperCase());
		System.out.println("User navigates to oppurtunity page " + "Passed");
	}

	@Given("User navigatess to new sales engagement page")
	public void user_navigatess_to_new_sales_engagement_page() {
		System.out.println("-->Function for " + "User navigatess to new sales engagement page".toUpperCase());
		System.out.println("User navigatess to new sales engagement page " + "Passed");
	}

	@When("User selects below record Type")
	public void user_selects_below_record_Type_for_sales_engagement(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("-->Function for " + "User selects below record Type".toUpperCase());
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			System.out.println("Record type is selected as \"" + data.get("Sales Engagement Group") + "\"" );		
		}
	}

	@Then("Below Sales Engagement Group and Request Type combination should be available for selection")
	public void below_Sales_Engagement_Group_and_Request_Type_combination_should_be_available_for_selection(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("-->Function for " + "Below Sales Engagement Group and Request Type combination should be available for selection".toUpperCase());
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			System.out.println("Engagement Group \""+ data.get("Sales Engagement Group") +"\" is availale for selection");
			System.out.println("Request Type \""+ data.get("Request Type") +"\" is availale for selection");		
		}
	}


	@Then("User creates sales engagement with below details")
	public void user_creates_sales_engagement_with_below_details(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("-->Function for " + "User creates sales engagement with below details".toUpperCase());
		System.out.println("User creates sales engagement with below details " + "Passed");
	}

	
	
	
	@When("User selects {string} for sales engagement")
	public void user_selects_record_Type_for_sales_engagement(String recordType) {
		System.out.println("-->Function for " + "User selects {string} for sales engagement".toUpperCase());
		System.out.println("Record type is selected as \"" + recordType + "\"" );
	}
	
	@Then("User creates with {string} and {string} combination")
	public void user_creates_with_Legal_Direct_and_Procurement_VMB_Supplier_combination(String Group, String requestType) {
		System.out.println("-->Function for " + "User creates with {string} and {string} combination".toUpperCase());
		System.out.println("Engagement Group \""+ Group +"\" is availale for selection");
		System.out.println("Request Type \""+ requestType +"\" is availale for selection");	
	}
	
}
