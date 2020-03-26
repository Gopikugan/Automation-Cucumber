package com.vmuat.testNG.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001 {
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@DataProvider
	public Object[][] dp() {
	  return new Object[][] {
	    new Object[] { 1, "a" },
	    new Object[] { 2, "b" },
	  };
	}
	
}
