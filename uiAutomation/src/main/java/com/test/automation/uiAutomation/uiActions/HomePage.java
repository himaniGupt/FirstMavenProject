package com.test.automation.uiAutomation.uiActions;

import java.awt.Menu;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase{
	
	public final String women = "Women";
	public final String dresses = "Dresses";
	public final String tshirts = "T-Shirts";
	public final String casualDress = "Casual Dresses";
	public final String eveningDress = "Evening Dresses";
	public final String summerDress = "Summer Dresses";

	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	@FindBy(xpath="//a[@class='login'][@title='Log in to your customer account']")
	WebElement signIn;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement logOut;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger']/ol/li")
	WebElement authenticationFailed;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement createEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createAccountButton;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement titleMrsRadioButton;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement dayDOB;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement monthDOB;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement yearsDOB;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement State;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobPhone;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement addressAlias;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement registerButton;
	
	@FindBy(xpath="//div[@id='center_column']/h1")
	WebElement myAccountTag;
	
	//WebDriverWait wait = new WebDriverWait(driver,20);
	
//	public HomePage(WebDriver driver)
//	{
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public HomePage(EventFiringWebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToApplication(String emailAddress, String password)
	{
		//WebElement signinbutton = driver.findElement(By.xpath("//a[@class='login'][@title='Log in to your customer account']"));
		//driver.navigate().refresh();
		//signinbutton.click(); --------- done to check Stale Element Exception
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.);
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//		WebElement element = wait.until(new Function<WebDriver,WebElement>()
//		public WebElement apply(WebDriver driver){
//			return signIn;
//		
//		});
//		Set<String> handles = driver.getWindowHandles();
//		for(String handle1:handles)
//		{
//			driver.switchTo().window(handle1);
//		}
		signIn.click();
		log("Clicked on SignIn and object is "+signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log("Entered email address: "+emailAddress+ " and object is "+loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		log("Entered password: "+password+" and object is "+loginPassword.toString());
		loginButton.click();
		log("Clicked on submit button and object is "+loginButton.toString());
	}
	
	public String getInvalidLoginText()
	{
		log("Error message is "+authenticationFailed.getText());
		return authenticationFailed.getText();
	}
	
	public void verifyRegistration(String email,String firstName,String lastName,String password,String day,String month,String year,String address,String city,String state,String zipcode,String mobPhone,String addressAlias)
	{
		signIn.click();
		log("Clicked on SignIn and object is "+signIn.toString());
		createEmail.clear();
		createEmail.sendKeys(email);
		log("Entered email and object is "+createEmail.toString());
		createAccountButton.click();
		log("Clicked on create account button and onject is "+createAccountButton.toString());
		titleMrsRadioButton.click();
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		this.password.clear();
		this.password.sendKeys(password);
		log("Entered password and object is "+this.password.toString());
		Select selectDay = new Select(dayDOB);
		selectDay.selectByVisibleText(day);
		Select selectMonth = new Select(monthDOB);
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(yearsDOB);
		selectYear.selectByVisibleText(year);
		log("Selected year and object is "+selectYear.toString());
		this.address.clear();
		this.address.sendKeys(address);
		this.city.clear();
		this.city.sendKeys(city);
		Select selectState = new Select(State);
		selectState.selectByValue(state);
		this.zipcode.clear();
		this.zipcode.sendKeys(zipcode);
		log("Enterted zipcode and object is "+this.zipcode.toString());
		this.mobPhone.sendKeys(mobPhone);
		this.addressAlias.clear();
		this.addressAlias.sendKeys(addressAlias);
		registerButton.click();
		
	}
	
	public boolean AccountCreationVerif()
	{
			if(myAccountTag.isDisplayed())
			{
				log("User has successfully logged into his/her account");
				return true;
			}
			else
				return false;		
	}
	
	public void logOutAccount()
	{
		
		//waitForElement(30, logOut);
		logOut.click();
		log("Clicked on SignOut button and object is "+logOut.toString());
	}
	
	public void clickOnNavigationMenu(String menuOption)
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("ul[class^='sf-menu']>li>a[title='"+menuOption+"']"))).build().perform();
		log("Mouse hover over option: "+menuOption);
		//ul[class^='sf-menu']>li>a[title='Women']-> menuOption=Women
		//ul[class^='sf-menu']>li>a[title='Dresses'] -> menuOption=Dresses
		//ul[class^='sf-menu']>li>a[title='T-shirts'] -> menuOption=T-Shirts
		if(menuOption.equals("T-Shirts")) {
			driver.findElement(By.cssSelector("ul[class^='sf-menu']>li>a[title='"+menuOption+"']")).click();
			log("Clicked on option: "+menuOption);
		}
	}
	
	public void clickOnProductInWomenSection(String apparelOption)
	{
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.cssSelector("ul[class^='sf-menu']>li>a[title='Women']+ul>li>ul>li>a[title='"+apparelOption+"']"))).build().perform();
		log("Clicked on apparel option: "+apparelOption+" in Women section");
		//"ul[class^='sf-menu']>li>a[title='Women']+ul>li>ul>li>a[title='Casual Dresses']" -> apparelOption=Casual Dresses
		//"ul[class^='sf-menu']>li>a[title='Women']+ul>li>ul>li>a[title='Casual Dresses']" -> apparelOption=Blouses
	}
	
	public void clickOnProductInDressesSection(String apparelOption)
	{
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.cssSelector("ul[class^='sf-menu']>li>a[title='Dresses']+ul>li>a[title='"+apparelOption+"']"))).build().perform();
		log("Clicked on apparel option: "+apparelOption+" in Dresses section");
		//ul[class^='sf-menu']>li>a[title='Dresses']+ul>li>a[title='Summer Dresses'] -> apparelOption=Casual Dresses
		//ul[class^='sf-menu']>li>a[title='Dresses']+ul>li>a[title='Summer Dresses'] -> apparelOption=Summer Dresses
	}
	
	public void log(String data)
	{
		log.info(data);
		Reporter.log(data);
	}
}
