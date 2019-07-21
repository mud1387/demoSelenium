package com.demo.helper.browserType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.demo.config.config;

public class chromeBrowser {
	
	public static config cf = new config();
	public ChromeOptions getChromeOptions() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chrome= DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		option.setCapability(ChromeOptions.CAPABILITY, chrome);
		
		return option;
		
	}
	
	public WebDriver getChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+cf.getChromePath());
		return new ChromeDriver();
	}
	
}
