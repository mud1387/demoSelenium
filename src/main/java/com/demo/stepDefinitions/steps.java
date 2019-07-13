package com.demo.stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.helper.assertion.assertionHelper;
import com.demo.helper.excel.excelHelper;
import com.demo.helper.verification.verificationHelper;
import com.demo.pageObject.loginPage;
import com.demo.testBase.testBase;

import io.cucumber.java.en.*;


public class steps {
	
	public WebDriver driver;
	
	public testBase tb;
	public loginPage lp;
	public verificationHelper vh;
	
	public static excelHelper exc= new excelHelper();
	public static Object[][] obj=exc.getExcelData(System.getProperty("user.dir")+"\\src\\resources\\testData.xlsx", "login");

	
	@Given("^User opens Chrome browser and launches the application URL \"([^\"]*)\"$")
	public void user_opens_Chrome_browser_and_launches_the_application_URL(String url) throws Throwable {
	
		//setupDriver(cf.getBrowser());
		tb = new testBase();
		tb.getApplicationUrl(url);
		driver=testBase.driver;
	}
	
	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) throws Throwable {
		
		lp= new loginPage(driver);
		String expectedTitle = title;
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		
		assertionHelper.verifyText(expectedTitle, actualTitle);

	}


	@When("^user clicks on sign in link$")
	public void user_clicks_on_sign_in_link() throws Throwable {
	    lp.clickSignIn();
	    Thread.sleep(3000);
	}

	/*
	 * @When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	 * public void user_enters_username_as_and_password_as_exceldata(String dataRow,
	 * String dataRow1) throws Throwable { exc.getExcelDataSet(obj, dataRow);
	 * lp.enterEmailAddress(excelHelper.username);
	 * lp.enterPassword(excelHelper.password); }
	 */

	@When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_username_as_and_password_as(String username, String password) throws Throwable {
		lp.enterEmailAddress(username);
	    lp.enterPassword(password);
	}
	
	@When("user enters username as {string}")
	public void user_enters_username_as(String dataRow) {
		
		 exc.getExcelDataSet(obj, dataRow);
		 lp.enterEmailAddress(excelHelper.username);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String dataRow) {
		 exc.getExcelDataSet(obj, dataRow);
		 lp.enterPassword(excelHelper.password);
	}

	
	@When("^clicks on submit button$")
	public void clicks_on_submit_button() throws Throwable {
	    lp.clickOnSubmitBtn();
	    Thread.sleep(1000);
	}

	@Then("^Error message is displayed on the page\\.$")
	public void error_message_is_displayed_on_the_page() throws Throwable {
		WebElement errorAuthentication=driver.findElement(By.xpath("//div[@id='create_account_error']"));
		vh= new verificationHelper(driver);
		if (vh.isDisplayed(errorAuthentication)) {
			System.out.println("Test Script executed");
		}
		else {
			System.out.println("Issue with test script execution");
		}
	}
	
}
