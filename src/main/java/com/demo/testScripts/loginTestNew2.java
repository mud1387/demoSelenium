package com.demo.testScripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.config.config;
import com.demo.helper.assertion.assertionHelper;
import com.demo.helper.browserType.browserType;
import com.demo.helper.browserType.chromeBrowser;
import com.demo.helper.excel.excelHelper;
import com.demo.helper.javaScript.javaScriptHelper;
import com.demo.helper.verification.verificationHelper;
import com.demo.helper.wait.waitHelper;
import com.demo.pageObject.loginPage;
import com.demo.testBase.testBase;

public class loginTestNew2 extends testBase {
	
	@Test
	public void loginTest() throws Exception {

		getApplicationUrl(cf.getUrl());
		String expectedTitle = cf.getHomePageTitle();
		String actualTitle = driver.getTitle();
		
		assertionHelper.verifyText(expectedTitle, actualTitle);
		getExcel();
		loginPage lp= new loginPage(driver);
		lp.loginToApplication(excelHelper.username,excelHelper.password);
		Thread.sleep(1000);

		/*WebElement errorAlertpwd = driver.findElement(By.xpath("//li[contains(text(),'Invalid password.')]"));
		WebElement errorAlertEmail=driver.findElement(By.xpath("//li[contains(text(),'Invalid email address.')]"));
		*/
		WebElement errorAuthentication=driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]"));
		/*if(vh.isDisplayed(errorAlertEmail)) {
			System.out.println("Test Script executed");
		}
		else if (vh.isDisplayed(errorAlertpwd)) {
			System.out.println("Test Script executed");
		}
		else*/ 
		if (vh.isDisplayed(errorAuthentication)) {
			System.out.println("Test Script executed");
		}
		else {
			System.out.println("Issue with test script execution");
		}

	}

	
}
