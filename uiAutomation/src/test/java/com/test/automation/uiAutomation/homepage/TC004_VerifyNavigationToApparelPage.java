package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC004_VerifyNavigationToApparelPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC004_VerifyNavigationToApparelPage.class.getName());
	
	@BeforeClass
	public void setup()
	{
		init("chrome","http://automationpractice.com/index.php");
	}
	
	@Test
	public void VerifyNavigationToApparelPage()
	{
		log.info("***********Starting TC004_VerifyNavigationToApparelPage***********");
		HomePage homepage = new HomePage(driver);
		homepage.clickOnNavigationMenu("Women");
		getScreenshot("TC004_VerifyNavigationToApparelPage_ClickOnWomen");
		homepage.clickOnProductInWomenSection("Blouses");
		getScreenshot("TC004_VerifyNavigationToApparelPage_ClickOnApparelOption");
		log.info("***********Finishing TC004_VerifyNavigationToApparelPage**********");
	}
	
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
}
