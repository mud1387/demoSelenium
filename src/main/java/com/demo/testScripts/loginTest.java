package com.demo.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.config.config;

public class loginTest {

	public static config cf;
	
	public static void main(String[] args) throws InterruptedException {
		// objects and variables instantiation
		
		cf= new config();
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+cf.getChromePath());
		WebDriver driver = new ChromeDriver();
		String appUrl = cf.getUrl();
		

		// launch the chrome browser and open the application url

		driver.get(appUrl);
		// maximize the browser window

		driver.manage().window().maximize();
		// declare and initialize the variable to store the expected title of the
		// webpage.

		String expectedTitle = "My Store";
		// fetch the title of the web page and save it into a string variable

		String actualTitle = driver.getTitle();
		// compare the expected title of the page with the actual title of the page and
		// print the result

		if (expectedTitle.equals(actualTitle))
		{
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		}else{
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}

		WebElement signIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
		
		signIn.click();
		
		WebElement loginEmailAddress= driver.findElement(By.xpath("//*[@id='email']"));
		
		if (loginEmailAddress.isDisplayed()) {
			
			loginEmailAddress.clear();
			loginEmailAddress.sendKeys(cf.getUsername());
		}		
		
		WebElement loginPassword = driver.findElement(By.xpath("//*[@id='passwd']"));
		
		loginPassword.clear();
		loginPassword.sendKeys(cf.getPassword());
		
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		
		WebElement errorAlert= driver.findElement(By.xpath("//li[contains(text(),'Invalid password.')]"));
		
		if (errorAlert.isDisplayed()) {
			
			System.out.println("Alert error found");
		}
		// close the web browser
		
		Thread.sleep(500);

		driver.close();

		System.out.println("Test script executed successfully.");

		// terminate the program

		System.exit(0);

	}

}
