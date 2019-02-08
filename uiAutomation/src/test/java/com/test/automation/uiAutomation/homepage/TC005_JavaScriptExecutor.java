package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;

public class TC005_JavaScriptExecutor extends TestBase{

	@BeforeClass
	public void setup() throws IOException
	{
		init();
	}
	
	@Test
	public void javaScriptExecutor() throws InterruptedException
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		
		//exe.executeScript("arguments[0].value=\"testselenium\"", driver.findElement(By.xpath("//input[@name='search_query'][@id='search_query_top']")));
		//Thread.sleep(2000);
		
		exe.executeScript("document.getElementById(\"search_query_top\").value=\"test\"");
		Thread.sleep(2000);
		
//		exe.executeScript("document.getElementsByClassName(\"search_query form-control ac_input\")");
//		Thread.sleep(2000);
	}
	
	@Test
	public void javaScriptExecutor2() throws InterruptedException
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		//document.getElementsByClassName("logo img-responsive")
		exe.executeScript("document.getElementsByClassName(\"logo img-responsive\")[0].click();");
		Thread.sleep(5000);
		
		exe.executeScript("arguments[0].click();", driver.findElement(By.className("img-responsive")));
		Thread.sleep(5000);
	}
	
}
