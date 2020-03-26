package com.vmuat.salesforce;

import java.util.Properties;

import com.vmuat.apiBase.Base;

public class GenericFunction extends Base{
	
	public Properties prop;
	
	
	public GenericFunction startApplication(String url) {
		driver = startApp(url);
		node = test.createNode(testCaseName);
		return this;
	}
	
	
	public LoginPage getLoginPage() {
		return new LoginPage(driver, node, test);
	}
	
	public void closeApplication() {
		close();
		
	}
	
	public void setTestcase(String testName, String testDescription, String testNodes, String authour, String catagory) {
		testCaseName = testName;
		testCaseDescription = testDescription;
		nodes = testNodes;
		authors = authour;
		category = catagory;
		
		test = extent.createTest(testCaseName, testCaseDescription);
		test.assignAuthor(authors);
		test.assignCategory(catagory); 
	}
		
	
	
}
