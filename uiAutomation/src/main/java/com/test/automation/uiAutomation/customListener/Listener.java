package com.test.automation.uiAutomation.customListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.TestBase;

public class Listener extends TestBase implements ITestListener{
	
//	WebDriver driver;
	
	/*public Listener(WebDriver driver){
		this.driver=driver;
	}*/

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test started running:"+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String methodName = result.getName();
		
		if(result.isSuccess())
		{
			Reporter.log("Test is success:"+result.getMethod().getMethodName() );
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/uiAutomation/";
			File destFile = new File((String) reportDirectory+"/success_screenshots/"+methodName+"_"+formatter.format(calendar.getTime())+".png");
			FileUtils.copyFile(srcFile, destFile);
			
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"' height='100' width='100'/></a>");
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String methodName = result.getName();
		
		if(!result.isSuccess())
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/uiAutomation/";
			File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formatter.format(calendar.getTime())+".png");
			FileUtils.copyFile(srcFile, destFile);
			
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"' height='100' width='100'/></a>");
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test is skipped:"+result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Test finished:");
		
	}

}
