package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC002_VerifyRegistration extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());
	HomePage homepage;
	
	
	@BeforeTest
	public void setup()
	{
		init("chrome","http://automationpractice.com/index.php");
		
	}
	
	@Test
	public void VerifyRegistration()
	{
		log.info("********************Starting TC002_VerifyRegistration***************************");
		homepage = new HomePage(driver);
		homepage.verifyRegistration("auto"+System.currentTimeMillis()+"@gmail.com","testName","testLastName","password@123","4  ","April ","1990  ","Sample Address","testCity","2","66678","5675675678","testAddress7");
		
		Assert.assertEquals(homepage.AccountCreationVerif(), true);
		log.info("*******************Finished TC002_VerifyRegistration******************************");
	}
	
	@AfterClass
	public void endTest()
	{
		
		driver.close();
	}
}
