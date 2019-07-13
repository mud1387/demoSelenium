package com.demo.testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.demo.config.config;
import com.demo.helper.browserType.browserType;
import com.demo.helper.browserType.chromeBrowser;
import com.demo.helper.excel.excelHelper;
import com.demo.helper.verification.verificationHelper;
import com.demo.helper.wait.waitHelper;
import com.google.common.io.Files;

public class testBase {

	public static WebDriver driver;
	public static config cf;
	public static File screenshotLoc;
	public static excelHelper ex;
	public static verificationHelper vh;

	
	@BeforeTest
	public void beforeTest() throws Exception {
		cf = new config();
		ex=new excelHelper();
		vh= new verificationHelper(driver);
		screenshotLoc = new File(System.getProperty("user.dir") + "\\src\\main\\java\\screenshots");
		setupDriver(cf.getBrowser());
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		System.exit(0);
	}

	public WebDriver getBrowserObject(browserType btyp) throws Exception {

		try {

			switch (btyp) {
			case chrome:
				chromeBrowser chrome = new chromeBrowser();
				return chrome.getChromeDriver();
			default:
				throw new Exception("Driver not found " + btyp.name());
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public void setupDriver(browserType btyp) throws Exception {

		driver = getBrowserObject(btyp);
		waitHelper wait = new waitHelper(driver);
		wait.setImplicitWait(cf.getImplicitWait(), TimeUnit.SECONDS);
		;
		driver.manage().window().maximize();
	}

	public void getApplicationUrl(String url) {

		driver.get(url);

	}

	public String captureScreen(String fileName) {

		if (driver == null) {

			return null;
		}
		if (fileName == "") {
			fileName = "blank";
		}

		File desFileName = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			desFileName = new File(screenshotLoc + "/" + formater.format(calendar.getTime()) + "png");
			Files.copy(srcFile, desFileName);
			Reporter.log("<a href='" + desFileName.getAbsolutePath() + "'><img src='" + desFileName.getAbsolutePath()
					+ "'height='100' width='100'/></a>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return desFileName.toString();
	}
	
	public static void getExcel() {
		Object[][] obj=ex.getExcelData(System.getProperty("user.dir")+"\\src\\resources\\testData.xlsx", "login");
		//ex.getExcelDataSet(obj);
		
	}

}
