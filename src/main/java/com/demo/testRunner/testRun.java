package com.demo.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.testBase.testBase;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = "src/features",
        glue = {"com.demo.stepDefinitions"},
        //dryRun = true,
        monochrome=true,
        plugin = {
                "pretty",
                "json:target/report/cucumber2.json"
        })
public class testRun extends testBase{

	private TestNGCucumberRunner testNGCucumberRunner;  

	@BeforeClass(alwaysRun = true)  
	    public void setUpClass() throws Exception {  
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	  }  

	    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
	    public void scenarioRun(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
	        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
	        
	  }  

	    @DataProvider(name="scenarios")  
	  public Object[][] scenarios() {  
		/*
		 * Object[][] obj=testNGCucumberRunner.provideScenarios(); for (int i = 0; i <
		 * obj.length; i++) { for (int j = 0; j < obj[i].length; j++) {
		 * System.out.println(obj[i][j]); } }
		 */
	         return testNGCucumberRunner.provideScenarios();
	    }  

	    @AfterClass(alwaysRun = true)  
	    public void tearDownClass() throws Exception {  
	        testNGCucumberRunner.finish();  
	  }  
	
	    
}
