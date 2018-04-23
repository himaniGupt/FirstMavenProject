package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.uiAutomation.customListener.Listener;
import com.test.automation.uiAutomation.excelReader.Excel_Reader;
import org.apache.commons.io.FileUtils;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	//String browser = "firefox";
	//String url = "http://automationpractice.com/index.php";
	Excel_Reader excel;
	Listener listener;
	
	public void init(String browser, String url)
	{
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	//	listener = new Listener(driver);
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
	
	public void getScreenshot(String name)
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshot/";
		File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(scrFile,destFile);
		//This will help to link screenshot with testNG report
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeBrowser()
	{
		driver.close();
		log.info("browser closed");
	}
	
//	public void waitForElement(int timeOutInSeconds, WebElement element)
//	{
//		
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
}
