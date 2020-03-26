package com.vmuat.apiBase;

import java.io.FileReader;
import java.util.Properties;

import com.vmuat.apiDesign.DriverType;
import com.vmuat.apiDesign.EnvironmentType;

public class BrowserConfig {
	private Properties browserProperties;
	private final String browserPropertiesFilePath= "./src/main/resources/BrowserConfig.properties";
	
	private String environment;
	private String browser;
	private String windowMaximize;
	private String driverPath;
	private String implicitlyWait;
	private String ExistingProfile;
	private String ProfilePath;
	private String maximumWait;
	
	
	public BrowserConfig() {
		try{
			FileReader reader=new FileReader(browserPropertiesFilePath);
			browserProperties=new Properties();  
			browserProperties.load(reader);
			reader.close(); 
		}catch(Exception e) {
			System.out.println("Error in loading properties file " + browserPropertiesFilePath);
			System.err.println(e.getCause());
		}
		
	}
	
	

	public EnvironmentType getEnvironment() {
		 environment = browserProperties.getProperty("environment");
		 if(environment == null || environment.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		 else if(environment.equals("remote")) return EnvironmentType.REMOTE;
		 else throw new RuntimeException("Environment Type Key value in BrowserConfig.properties is not matched : " + environment);
	}
	
	 public DriverType getBrowser() {
		 browser = browserProperties.getProperty("browser");
		 if(browser == null || browser.equals("chrome")) return DriverType.CHROME;
		 else if(browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		 else if(browser.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		 else throw new RuntimeException("Browser Name Key value in BrowserConfig.properties is not matched : " + browser);
		 }
	
	public Boolean getWindowMaximize() {
		 windowMaximize = browserProperties.getProperty("windowMaximize");
		 if(windowMaximize != null) return Boolean.valueOf(windowMaximize);
		 return true;
	}
	
	public String getDriverPath(){
		 driverPath = browserProperties.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("Driver Path not specified in the BrowserConfig.properties file for the Key:driverPath"); 
	}
	
	public long getImplicitlyWait() {
		 implicitlyWait = browserProperties.getProperty("implicitlyWait");
		 if(implicitlyWait != null) {
			 try{
				 return Long.parseLong(implicitlyWait);
			 }catch(NumberFormatException e) {
				 throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			 }
		 }
		 return 30; 
	}
	
	public long getMaximumWait() {
		maximumWait = browserProperties.getProperty("maximumWait");
		 if(maximumWait != null) {
			 try{
				 return Long.parseLong(maximumWait);
			 }catch(NumberFormatException e) {
				 throw new RuntimeException("Not able to parse value : " + maximumWait + " in to Long");
			 }
		 }
		 return 30; 
	}
	
	public Boolean getExistingProfile() {
		ExistingProfile = browserProperties.getProperty("ExistingProfile");
		if(ExistingProfile != null) return Boolean.valueOf(ExistingProfile);
		return true;
	}
	
	public String getProfilePath() {
		ProfilePath = browserProperties.getProperty("ProfilePath");
		if(ProfilePath!= null) return ProfilePath;
		else throw new RuntimeException("Profile Path not specified in the BrowserConfig.properties file for the Key:ProfilePath"); 
	}
}
