package com.vmuat.manager;

import com.vmuat.apiBase.BrowserConfig;

public class ConfigurationManager {
 
 private static ConfigurationManager configurationManager = new ConfigurationManager();
 private static BrowserConfig browserConfig;
 
	 public static ConfigurationManager getInstance( ) {
	       return configurationManager;
	 }
	 
	 public BrowserConfig getbrowserConfig() {
		 return (browserConfig == null) ? new BrowserConfig() : browserConfig;
	 }
	 
	 
}
