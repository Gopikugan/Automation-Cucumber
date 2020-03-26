package com.vmuat.cucumber.runners;

import com.vmuat.apiBase.Base;

import io.cucumber.testng.CucumberOptions;


/*import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;*/

@CucumberOptions(
		 strict = true, 
		 features = {"./src/test/java/com/vmuat/cucumber/features"},
		 glue = {"com.vmuat.cucumber.stepDefinitions"},
		 dryRun = false,
		 monochrome = true,
		 tags = {"@SCCI_Dummy_Demo"},
		 plugin= {"pretty",
				 "usage:target/cucumber-reports/usage.json",
				 "summary",
				 "html:target/cucumber-reports",
		 		 "json:target/cucumber-reports/cucumber.json",
		 		 "junit:target/cucumber-reports/cucumber.xml"
		/*
		 * , "cucumber-reporting:target/pretty-cucumber/tmlReport.html",
		 * "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber/pretty.html"
		 */
		 }
		 
		 )
public class TestNGRunner extends Base{
	 
	
}
