package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.customListener.Listener;
import com.test.automation.uiAutomation.customListener.WebEventListener;
import com.test.automation.uiAutomation.excelReader.Excel_Reader;
import org.apache.commons.io.FileUtils;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver dr;
	//String browser = "firefox";
	//String url = "http://automationpractice.com/index.php";
	Excel_Reader excel;
	Listener listener;
	public EventFiringWebDriver driver;
	WebEventListener eventListener;
	protected Properties OR;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void init() throws IOException
	{
		getDataFromConfig();
		
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	//	listener = new Listener(driver);
	}
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiAutomation/report/test"+formater.format(calendar.getTime())+".html",false);
	}
	
	public void getDataFromConfig() throws IOException
	{
		OR = new Properties();
		File file = new File(System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiAutomation/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			log("Creating object of "+browser);
			dr = new FirefoxDriver();
			driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			driver.register(eventListener);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			log("Creating object of "+browser);
			dr = new ChromeDriver();
			driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			driver.register(eventListener);
			
		}
	}
	
	public void getUrl(String url)
	{
		log("Navigating to "+url);
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
	
	public String captureScreen(String filename)
	{
		if(filename=="")
		{
			filename = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshot/";
		destFile = new File((String) reportDirectory + filename + "_" + formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(scrFile,destFile);
		//This will help to link screenshot with testNG report
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return destFile.toString(); 
	}
	
	public void closeBrowser()
	{
		driver.quit();
		log("browser closed");
		extent.endTest(test);//to end the test which we started in beforemethod method
		extent.flush();//this will flush the report to html
	}
	
	public Iterator<String> getAllWindows()
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		return itr;
	}
//	public void waitForElement(int timeOutInSeconds, WebElement element)
//	{
//		
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
	
	public void log(String data)
	{
		log.info(data);
		Reporter.log(data);
	}
	
	public void getresult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, result.getName()+" test is pass");
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, result.getName()+" test is skipped and skip reason is "+result.getThrowable());
		}else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.ERROR, result.getName()+" test is failed "+result.getThrowable());
			test.log(LogStatus.FAIL, test.addScreenCapture(captureScreen("")));
		}else if(result.getStatus()==ITestResult.STARTED)
		{
			test.log(LogStatus.INFO, result.getName()+" test is started");
		}
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method result)
	{
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+" test started");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		getresult(result);
	}
	
	@AfterClass(alwaysRun=true)
	public void endTest()
	{
		closeBrowser();
	}
}
