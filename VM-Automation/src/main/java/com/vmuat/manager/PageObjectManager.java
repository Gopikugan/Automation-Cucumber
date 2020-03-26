package com.vmuat.manager;

import com.vmuat.apiBase.Base;
import com.vmuat.salesforce.AccountsPage;
import com.vmuat.salesforce.CreateLeadPage;
import com.vmuat.salesforce.HomePage;
import com.vmuat.salesforce.LeadPage;
import com.vmuat.salesforce.Lead_AddressSearchPage;
import com.vmuat.salesforce.LoginPage;
import com.vmuat.salesforce.OppurtunityPage;
import com.vmuat.salesforce.SalesEngagementPage;

public class PageObjectManager extends Base{
	
	
	private LoginPage loginpage;
	private HomePage homepage;
	private LeadPage leadpage;
	private CreateLeadPage createleadpage;
	private Lead_AddressSearchPage leadAddressSearchPage ;
	private AccountsPage accountspage ;
	private OppurtunityPage oppurtunityPage;
	private SalesEngagementPage salesEngagementPage;
	
	
	public LoginPage getLoginPage() {
		return (loginpage==null)?loginpage=new LoginPage(driver, node, test):loginpage;
	}
	
	public HomePage getHomePage() {
		return (homepage==null)?homepage=new HomePage(driver, node, test):homepage;
	}
	
	public LeadPage getLeadPage() {
		return (leadpage==null)?leadpage=new LeadPage(driver, node, test):leadpage;
	}
	
	public CreateLeadPage getCreateLeadPage() {
		return (createleadpage==null)?createleadpage=new CreateLeadPage(driver, node, test):createleadpage;
	}
	
	public AccountsPage getAccountsPage() {
		return (accountspage==null)?accountspage=new AccountsPage(driver, node, test):accountspage;
	}
	
	public OppurtunityPage getOppurtunityPage() {
		return (oppurtunityPage==null)?oppurtunityPage=new OppurtunityPage(driver, node, test):oppurtunityPage;
	}
	
	public SalesEngagementPage getSalesEngagementPage() {
		return (salesEngagementPage==null)?salesEngagementPage=new SalesEngagementPage(driver, node, test):salesEngagementPage;
	}
	
	public Lead_AddressSearchPage getLeadAddressSearchPage() {
		return (leadAddressSearchPage==null)?leadAddressSearchPage=new Lead_AddressSearchPage(driver, node, test):leadAddressSearchPage;
	}
	
}
