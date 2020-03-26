package com.vmuat.cucumber.stepDefinitions;


import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class cucumberHooks {
	
	
	@Before("not @SCCI_Dummy_Demo")
	public void report(Scenario s) {
    	//new  GenericFunction().setTestcase("Test_Testcase", "Test_Testdescription", "Test_nodes", "Test_authour", "Test_catogry");
	}
	
	@Before
	public void before(Scenario s) {
		
	}
	
	//@BeforeStep
	public void beforeStep(Scenario scenario) {
		
		/*
		 * try{ Field f = scenario.getClass().getDeclaredField("delegate");
		 * f.setAccessible(true); TestCase r = (TestCase) f.get(scenario);
		 * 
		 * 
		 * //You need to filter out before/after hooks List<PickleStepTestStep> stepDefs
		 * = r.getTestSteps() .stream() .filter(x -> x instanceof PickleStepTestStep)
		 * .map(x -> (PickleStepTestStep) x) .collect(Collectors.toList());
		 * 
		 * 
		 * //This object now holds the information about the current step definition
		 * //If you are using pico container //just store it somewhere in your world
		 * state object //and to make it available in your step definitions.
		 * PickleStepTestStep currentStepDef = stepDefs .get(currentStepDefIndex);
		 * 
		 * 
		 * System.out.println("currentStepDef " + currentStepDef);
		 * 
		 * }catch(Exception e) { e.printStackTrace(); System.out.println("Exception  " +
		 * e); }
		 */
		
		
	}

	@AfterStep
	public void afterStep(Scenario s) {
		
	}


}	



