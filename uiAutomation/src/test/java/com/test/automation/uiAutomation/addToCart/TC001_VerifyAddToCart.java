package com.test.automation.uiAutomation.addToCart;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.AddToCart;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.ProductDetailsPage;

public class TC001_VerifyAddToCart extends TestBase{
	HomePage homepage;
	ProductDetailsPage productDetailsPage;
	AddToCart addToCart;
	
	@BeforeClass
	public void setup() throws IOException
	{
		init();
	}
	
	@Test
	public void VerifyAddToCart() throws InterruptedException
	{
		log.info("********Starting VerifyAddToCart**************");
		homepage = new HomePage(driver);
		
		homepage.clickOnNavigationMenu(homepage.dresses);
		homepage.clickOnProductInDressesSection(homepage.casualDress);
//		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectProduct(productDetailsPage.PrintedDress);
//		addToCart = new AddToCart(driver);
		addToCart = new AddToCart(driver);
		addToCart.clickOnAddToCart();
		//Thread.sleep(10000);
		log.info("**********Finished VerifyAddToCart***********");
	}
	
	@AfterClass
	public void endTest()
	{
		closeBrowser();
		
	}

}
