package com.vmuat.manager;

public class TestContext {
	
	 public PageObjectManager getPageObjectManager() {
		 return new PageObjectManager();
	 }
	 public ConfigurationManager getconfigurationManager() {
		 return new ConfigurationManager();
	 }

	 
	/*
	 * private PageObjectManager pageObjectManager; private ConfigurationManager
	 * configurationManager;
	 * 
	 * public PageObjectManager getLoginPage() { return
	 * (pageObjectManager==null)?pageObjectManager=new
	 * PageObjectManager():pageObjectManager; }
	 * 
	 * public ConfigurationManager getHomePage() { return
	 * (configurationManager==null)?configurationManager=new
	 * ConfigurationManager():configurationManager; }
	 */
	
}
