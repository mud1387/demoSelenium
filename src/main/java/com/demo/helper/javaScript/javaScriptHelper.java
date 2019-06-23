package com.demo.helper.javaScript;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptHelper {

	private WebDriver driver;
	
	public javaScriptHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public Object executeScript(String script) {
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	public Object executeScript(String script, Object...args) {
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	public void scrollToElement(WebElement element) {
		
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element) {
		
		scrollToElement(element);
		element.click();
	}
	

	public void scrollIntoView(WebElement element) {
		
		executeScript("arguments[0].scrollIntoView",element);
	}
	
	public void scrollIntoViewAndClick(WebElement element) {
		
		scrollIntoView(element);
		element.click();
	}
	

	public void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
}
