package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.uiAutomation.excelReader.Excel_Reader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	//String browser = "firefox";
	//String url = "http://automationpractice.com/index.php";
	Excel_Reader excel;
	
	public void init(String browser, String url)
	{
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			log.info("Creating object of "+browser);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			log.info("Creating object of "+browser);
			driver = new ChromeDriver();
		}
	}
	
	public void getUrl(String url)
	{
		log.info("Navigating to "+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public String [][] getData(String excelName, String sheetname)
	{
		String path= System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiAutomation/data/"+excelName;
		excel = new Excel_Reader(path);
		String [][] data=excel.getDataFromSheet(sheetname, excelName);
		return data;				
	}
	
//	public void waitForElement(int timeOutInSeconds, WebElement element)
//	{
//		
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
}
