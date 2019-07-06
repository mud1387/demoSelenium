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
                "html:test-output"
        })
public class testRun extends testBase{

	private TestNGCucumberRunner testNGCucumberRunner;  

	  @BeforeClass(alwaysRun = true)  
	    public void setUpClass() throws Exception {  
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
	  }  

	    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
	    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
	        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
	  }  

	    @DataProvider  
	  public Object[][] scenarios() {  
	        return testNGCucumberRunner.provideScenarios();  
	  }  

	    @AfterClass(alwaysRun = true)  
	    public void tearDownClass() throws Exception {  
	        testNGCucumberRunner.finish();  
	  }  
	
}
