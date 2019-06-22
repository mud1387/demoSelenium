package com.demo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.demo.helper.verification.verificationHelper;

public class loginPage {
	
	private WebDriver driver;
	verificationHelper vh= new verificationHelper(driver);
	//private Logger log=loggerHelper.getLogger(loginPage.class);
	//waitHelper waitHelper;
	
	@FindBy(how=How.XPATH, using="//*[@id='email']")
	@CacheLookup
	WebElement loginEmailAddress;
	
	@FindBy(how=How.XPATH, using="//*[@id='passwd']")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	@CacheLookup
	WebElement submitButton;
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//waitHelper = new waitHelper(driver);
		//waitHelper.waitForElementVisibleWithPollingTime(signIn, 20, 500);
		
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
	
	public void loginToApplication(String email, String pwd) {
		enterEmailAddress(email);
		enterPassword(pwd);
		clickOnSubmitBtn();
	}
	
}
