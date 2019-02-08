package com.test.automation.uiAutomation.MiscLearning;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.MiscLearningJava.HandleCaptcha;
import com.test.automation.uiAutomation.testBase.TestBase;

public class TC007_HandleCaptcha extends TestBase{

	
	public static final Logger log = Logger.getLogger(TC006_HandleWebTable.class.getName());
	HandleCaptcha handleCaptcha;
	
	@BeforeTest
	public void setup() throws IOException
	{
		
		init();
		
	}
	
	@Test
	public void enterCaptchaValue()
	{
		handleCaptcha = new HandleCaptcha(driver);
		getUrl(OR.getProperty("captchaurl"));
		handleCaptcha.captcha();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
