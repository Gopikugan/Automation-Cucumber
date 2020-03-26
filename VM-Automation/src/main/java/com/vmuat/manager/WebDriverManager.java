package com.vmuat.manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.vmuat.apiDesign.DriverType;
import com.vmuat.apiDesign.EnvironmentType;

public class WebDriverManager {
	 private RemoteWebDriver driver;
	 private static DriverType driverType;
	 private static EnvironmentType environmentType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	 private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	 private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	 
	 
	 public WebDriverManager() {
		 driverType = ConfigurationManager.getInstance().getbrowserConfig().getBrowser();
		 environmentType = ConfigurationManager.getInstance().getbrowserConfig().getEnvironment();
	 }
	 
	 public RemoteWebDriver getDriver() {
		 if(driver == null) driver = createDriver();
		 return driver;
	 }
		 
	 private RemoteWebDriver createDriver() {
	    switch (environmentType){
	    case LOCAL:
	    	driver = createLocalDriver();
	     	break;
	    case REMOTE:
	    	driver = createRemoteDriver();
	     	break;
	    }
	    return driver;
	 }
		 
	 private RemoteWebDriver createRemoteDriver() {
		 throw new RuntimeException("RemoteWebDriver is not yet implemented");
	 }
		 
	 private RemoteWebDriver createLocalDriver() {
	        switch (driverType){    
	        case FIREFOX:
	        	System.setProperty(FIREFOX_DRIVER_PROPERTY, ConfigurationManager.getInstance().getbrowserConfig().getDriverPath());
	        	driver = new FirefoxDriver();
	        	break;
	        case CHROME:
	        	System.setProperty(CHROME_DRIVER_PROPERTY, ConfigurationManager.getInstance().getbrowserConfig().getDriverPath());
	        	if(ConfigurationManager.getInstance().getbrowserConfig().getExistingProfile()) {
	        		ChromeOptions options = new ChromeOptions();
					options.addArguments("chrome.switches", "--disable-extentions");
					options.addArguments("--profile-directory=Default");
					options.addArguments("user-data-dir=" + ConfigurationManager.getInstance().getbrowserConfig().getProfilePath());
					driver = new ChromeDriver(options);
	        	}else {
	        		driver = new ChromeDriver();
	        	}
	        	
	        	break;
	        case INTERNETEXPLORER : 
	        	System.setProperty(IE_DRIVER_PROPERTY, ConfigurationManager.getInstance().getbrowserConfig().getDriverPath());
	        	driver = new InternetExplorerDriver();
	        	break;
	        }
		 
	        if(ConfigurationManager.getInstance().getbrowserConfig().getWindowMaximize())
	        	driver.manage().window().maximize();
	        //driver.manage().timeouts().implicitlyWait(ConfigurationManager.getInstance().getbrowserConfig().getImplicitlyWait(), TimeUnit.SECONDS);
		 return driver;
	 } 
		 
	 public void closeDriver(RemoteWebDriver driver) {
		 driver.close();
		 driver.quit();
	 }
}	
