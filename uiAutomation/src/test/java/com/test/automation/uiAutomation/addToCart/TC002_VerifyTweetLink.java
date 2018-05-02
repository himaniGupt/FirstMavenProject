package com.test.automation.uiAutomation.addToCart;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.AddToCart;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.ProductDetailsPage;

public class TC002_VerifyTweetLink extends TestBase{
	HomePage homepage;
	AddToCart addtoCart;
	ProductDetailsPage productDetailsPage;
	
	@BeforeClass
	public void setup() throws IOException
	{
		init();
	}
	
	@Test
	public void VerifyTweetLink() throws InterruptedException
	{
		log.info("********Starting VerifyAddToCart**************");
		homepage = new HomePage(driver);
		homepage.clickOnNavigationMenu(homepage.dresses);
		homepage.clickOnProductInDressesSection(homepage.casualDress);
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectProduct(productDetailsPage.PrintedDress);
		addtoCart = new AddToCart(driver);
		//String parentWindowHandle = driver.getWindowHandle();
		addtoCart.clickOnTweet();
		//to get all windows
		Iterator<String> itr = getAllWindows();
		String parentWindowHandle = itr.next();
		String childWindow = itr.next();
		
		driver.switchTo().window(childWindow);
		Boolean status = addtoCart.VerifytweetMessage();
		
		Thread.sleep(5000);
		Assert.assertEquals(true, status);
		
		
		log.info("**********Finished VerifyAddToCart***********");
	}
	
//	@AfterClass
//	public void endTest()
//	{
//		closeBrowser();
//	}

}
