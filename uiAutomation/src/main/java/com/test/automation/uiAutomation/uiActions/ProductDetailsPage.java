package com.test.automation.uiAutomation.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class ProductDetailsPage extends TestBase{
	
	public final static Logger log = Logger.getLogger(ProductDetailsPage.class.getName());

	public final String Blouse = "Blouse";
	public final String PrintedChiffonDress = "Printed Chiffon Dress";
	public final String PrintedDress = "Printed Dress";
	public final String PrintedSummerDress = "Printed Summer Dress";
	public final String FadedShortSleeveTshirts = "Faded Short Sleeve T-shirts";
	
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-container']")
	List<WebElement> products;
	
	@FindBy(xpath="//p[@id='add_to_cart']/button[@name='Submit']")
	WebElement addToCartButton;
	
	public void selectProduct(String product)
	{
		driver.findElement(By.xpath("//div[@class='product-container']//a[contains(text(),'"+product+"')]")).click();
		log.info(product+" has been selected");
	}
	
	public List<WebElement> selectProduct()
	{
		List<WebElement> products_list = products;
		return products_list;
	}
	
	public void clickOnAddToCart()
	{
		addToCartButton.click();
	}
}
