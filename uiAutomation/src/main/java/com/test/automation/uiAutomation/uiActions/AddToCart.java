package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;

public class AddToCart extends TestBase{
	
	public static final Logger log = Logger.getLogger(AddToCart.class.getName());
	
	@FindBy(xpath="//p[@id='add_to_cart']/button[@name='Submit']")
	WebElement addToCartButton;
	
	@FindBy(css="button[class='btn btn-default btn-twitter']")
	WebElement tweetButton;
	
	@FindBy(css="h2[class='action-information']")
	WebElement tweetPageInfo;
	
//	public AddToCart(WebDriver driver)
//	{
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public AddToCart(EventFiringWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToCart()
	{
		addToCartButton.click();
		log("Clicked on add to cart button and object is "+addToCartButton.getText());
		
	}
	
	public void clickOnTweet()
	{
		tweetButton.click();
		log("Clicked on tweet button and object is "+tweetButton.getText());
	}
	
	public boolean VerifytweetMessage()
	{
		try {
		return tweetPageInfo.isDisplayed();
		}
		catch(Exception e){
		return false;
		}
	}
}
