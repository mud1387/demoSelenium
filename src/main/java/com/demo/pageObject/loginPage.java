package com.demo.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.demo.helper.javaScript.javaScriptHelper;
import com.demo.helper.verification.verificationHelper;

public class loginPage {
	
	private  WebDriver driver;
	//private Logger log=loggerHelper.getLogger(loginPage.class);
	//waitHelper waitHelper;
	@FindBy(how=How.XPATH, using="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	@CacheLookup
	WebElement signIn;
	
	@FindBy(how=How.XPATH, using="//*[@id='email']")
	@CacheLookup
	WebElement loginEmailAddress;
	
	@FindBy(how=How.XPATH, using="//*[@id='passwd']")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	@CacheLookup
	WebElement submitButton;
	
	public static verificationHelper vh;
	public static javaScriptHelper js;
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//waitHelper = new waitHelper(driver);
		//waitHelper.waitForElementVisibleWithPollingTime(signIn, 20, 500);
		vh= new verificationHelper(driver);
		js = new javaScriptHelper(driver);
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public void clickOnSubmitBtn() {
		vh.isDisplayed(submitButton);
		submitButton.click();
		
	}
	
	public void enterEmailAddress(String email) {
		vh.isDisplayed(loginEmailAddress);
		loginEmailAddress.clear();
		loginEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		vh.isDisplayed(loginPassword);
		loginPassword.clear();
		loginPassword.sendKeys(pwd);
	}
	
	public void loginToApplication(String email, String pwd) throws InterruptedException {
		clickSignIn();
		Thread.sleep(5000);
		System.out.println("Clicked on Signin link");
		/*js.scrollDownVertically();
		System.out.println("Scrolled down the bar");
		*/enterEmailAddress(email);
		System.out.println("Entered emailId");
		enterPassword(pwd);
		System.out.println("Entered Password");
		clickOnSubmitBtn();
		System.out.println("Clicked on Submit button");
	}
	
}
