package com.vmuat.report;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@SuppressWarnings("deprecation")
public abstract class ExtentReport extends AbstractTestNGCucumberTests{
	
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest node;
	
	public static String testCaseName, testCaseDescription, nodes, authors,category;
	public static String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		System.out.println("@BEFORE SUITE");
		reporter = new ExtentHtmlReporter("./extent-reports/result.html");
		//reporter.setAppendExisting(true); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	/*
	 * @BeforeClass public void report() { System.out.println("@BEFORE CLASS"); test
	 * = extent.createTest(testCaseName, testCaseDescription);
	 * test.assignAuthor(authors); test.assignCategory(category); }
	 */
    
    @AfterSuite
    public void stopReport() {
    	System.out.println("@AFTER SUITE");
    	extent.flush();
    }
    
    public abstract long takeSnap();
    
    public void reportStep(String dec, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../extent-reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img);
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

}














