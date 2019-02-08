package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase{

	public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());
	HomePage homepage;
	
	@DataProvider(name="LoginData")
	public String[][] getTestData()
	{
		String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		return testRecords;
	}
	
	
	@BeforeClass
	public void setup() throws IOException
	{
		init();
	}
	
	
	@Test(dataProvider="LoginData",alwaysRun=true)
	public void TestLogin(String emailAddress, String password, String runMode)
	{
		if(runMode.equalsIgnoreCase("n"))
		{
			throw new SkipException("user marked this record as no run");
		}else
		{
		log.info("********************Starting TC003_VerifyLoginWithDifferentRecords***************************");
		homepage = new HomePage(driver);
		homepage.loginToApplication(emailAddress, password);
		boolean status = homepage.AccountCreationVerif();
		System.out.println("status is "+status);
		getScreenshot("testLogin_"+emailAddress);
		if(status)
		{
			homepage.logOutAccount();
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(status, true);
		//Assert.assertEquals(status, true);
		log.info("*******************Finished TC003_VerifyLoginWithDifferentRecords******************************");
		}
	}
	
//	@Test
//	public void TestLogin()
//	{
//		
//		log.info("********************Starting TC003_VerifyLoginWithDifferentRecords***************************");
//		homepage = new HomePage(driver);
//		homepage.loginToApplication("testautomation4@gmail.com", "password@123");
//		boolean status = homepage.AccountCreationVerif();
//		System.out.println("status is "+status);
//		if(status)
//		{
//			homepage.logOutAccount();
//		}
//		
//		log.info("*******************Finished TC003_VerifyLoginWithDifferentRecords******************************");
//		
//	}
	
//	@AfterClass
//	public void endTest()
//	{
//		driver.close();
//	}
}
