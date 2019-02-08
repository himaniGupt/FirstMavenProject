package com.test.automation.uiAutomation.MiscLearningJava;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class HandleCaptcha extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath="//input[@name='captchacode']")
	WebElement captchaTxtField;
	
	public HandleCaptcha(EventFiringWebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void captcha()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter captcha");
		String captchaValue = in.nextLine();
		captchaTxtField.sendKeys(captchaValue);
		
	}
	
	public void testRobotClass() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	
	

}
