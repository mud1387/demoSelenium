package com.demo.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.demo.config.config;
import com.demo.helper.browserType.browserType;
import com.demo.helper.browserType.chromeBrowser;
import com.demo.helper.verification.verificationHelper;
import com.demo.helper.wait.waitHelper;
import com.demo.pageObject.loginPage;

public class loginTestNew {

	public static config cf;
	public static loginPage lp;
	public static verificationHelper vh;
	public static chromeBrowser cb;
	public static waitHelper wait;

	public static WebDriver getBrowserObject(browserType btyp) throws Exception {
		
		try {
			
			switch(btyp) {
			case chrome:
				cb= new chromeBrowser();
				return cb.getChromeDriver();	
			default:
				throw new Exception(btyp.name());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {

		// objects and variables instantiation
		
		cf = new config();
		WebDriver driver = getBrowserObject(cf.getBrowser());
		
		String appUrl = cf.getUrl();
		
		vh= new verificationHelper(driver);
		lp= new loginPage(driver);
		wait= new waitHelper(driver);
		
		wait.setImplicitWait(cf.getImplicitWait(),TimeUnit.SECONDS);

		// launch the chrome browser and open the application url

		driver.get(appUrl);
		// maximize the browser window

		driver.manage().window().maximize();
		// declare and initialize the variable to store the expected title of the
		// webpage.

		String expectedTitle = cf.getHomePageTitle();
		// fetch the title of the web page and save it into a string variable

		String actualTitle = driver.getTitle();
		// compare the expected title of the page with the actual title of the page and
		// print the result

		if(vh.compareText(expectedTitle, actualTitle)) {
			
			WebElement signIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));

			signIn.click();
			
			lp.loginToApplication(cf.getUsername(), cf.getPassword());
			
			WebElement errorAlert = driver.findElement(By.xpath("//li[contains(text(),'Invalid password.')]"));

			vh.isDisplayed(errorAlert);

		}
		
		
		// close the web browser

		Thread.sleep(500);

		driver.close();

		System.out.println("Test script executed successfully.");

		// terminate the program

		System.exit(0);

	}

}
