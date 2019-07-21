package com.demo.helper.verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verificationHelper {

	private WebDriver driver;
	
	//private Logger log=loggerHelper.getLogger(verificationHelper.class);
	
	public verificationHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element) {
		
		try {
			
			element.isDisplayed();
			//log.info("Element is displayed "+element.getText());
			System.out.println(element+" is displayed");
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			//log.error("Element is not present "+e.getCause());
			System.out.println(element+" is not present");
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		
		try {
			
			element.isDisplayed();
			//log.info("Element is displayed ");
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			//log.error("Element is not present ");
			return true;
		}
	}
	
	public String getText(WebElement element) {
		
		if (element==null) {
			return null;
		}
		if(isDisplayed(element)) {
			return element.getText();
		}
		return null;
		
	}
	
	public boolean compareText(String actual, String expected) {
		
		if (expected.equals(actual)) {
			System.out.println("Verification Successful on the web page. "+actual+" matches "+expected);
			return true;
		} else {
			System.out.println("Verification Failed on the web page. "+actual+" does not match with "+expected);
			return false;
		}

	}
}

