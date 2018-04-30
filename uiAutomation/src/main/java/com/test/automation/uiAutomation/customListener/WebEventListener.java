package com.test.automation.uiAutomation.customListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListener implements WebDriverEventListener{

	public static final Logger log = Logger.getLogger(WebEventListener.class.getName());
	
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		//log("Before navigating to: '"+url+"' ");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log("Navigate to: '"+url+"'");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		log("Navigating back to previous page and current url is: "+driver.getCurrentUrl());
		
	}

	public void afterNavigateBack(WebDriver driver) {
		log("Navigated back to previous page and url is: "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		log("Navigating forward to next page and current url is: "+driver.getCurrentUrl());
		
	}

	public void afterNavigateForward(WebDriver driver) {
		log("Navigated forward to next page and url is: "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	//	log("Trying to find element By: "+by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log("Found element By: "+by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log("Trying to click on: "+element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log("Clicked on: "+element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log("Element value changed to: "+element.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
		log("Just before beforeScript: "+driver);
		
	}

	public void afterScript(String script, WebDriver driver) {
		log("Just after aftreScript: "+driver);
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		log("Exception occured: "+throwable);
		Reporter.log("Exception occured: ",false);
		
	}
	
	public void log(String data)
	{
		log.info(data);
		Reporter.log(data);
	}

}
