package com.demo.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class waitHelper {

	private WebDriver driver;
	
	
	public waitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeOut, TimeUnit unit) {
		
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
		System.out.println("Implicit Wait has been set to "+ timeOut);
		
	}
	
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryMilliSec) {
		
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryMilliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSec, int pollingEveryMilliSec) {
		
		System.out.println("Waiting for element "+ element.toString()+"for :"+timeOutInSec);
		WebDriverWait wait=getWait(timeOutInSec, pollingEveryMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Element is visible now");
	}
	
	public void waitForElementClickable(WebElement element, int timeOutInSec, int pollingEveryMilliSec) {
		
		System.out.println("Waiting for element "+ element.toString()+"for :"+timeOutInSec);
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Element is clickable now");
	}
	
	public void pageLoadTime(long timeOutInSec, TimeUnit unit) {
		
		System.out.println("Waiting for page to load for  "+ timeOutInSec+"for :"+unit);
		driver.manage().timeouts().pageLoadTimeout(timeOutInSec, unit);
		System.out.println("Page is loaded");
	}
}
