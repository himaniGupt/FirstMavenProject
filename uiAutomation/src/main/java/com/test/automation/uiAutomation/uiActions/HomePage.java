package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage {

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
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToApplication(String emailAddress, String password)
	{
		signIn.click();
		log.info("Clicked on SignIn and object is "+signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log.info("Entered email address: "+emailAddress+ " and object is "+loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		log.info("Entered password: "+password+" and object is "+loginPassword.toString());
		loginButton.click();
		log.info("Clicked on submit button and object is "+loginButton.toString());
	}
	
	public String getInvalidLoginText()
	{
		log.info("Error message is "+authenticationFailed.getText());
		return authenticationFailed.getText();
	}
	
	public void verifyRegistration(String email,String firstName,String lastName,String password,String day,String month,String year,String address,String city,String state,String zipcode,String mobPhone,String addressAlias)
	{
		signIn.click();
		log.info("Clicked on SignIn and object is "+signIn.toString());
		createEmail.clear();
		createEmail.sendKeys(email);
		log.info("Entered email and object is "+createEmail.toString());
		createAccountButton.click();
		log.info("Clicked on create account button and onject is "+createAccountButton.toString());
		titleMrsRadioButton.click();
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		this.password.clear();
		this.password.sendKeys(password);
		log.info("Entered password and object is "+this.password.toString());
		Select selectDay = new Select(dayDOB);
		selectDay.selectByVisibleText(day);
		Select selectMonth = new Select(monthDOB);
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(yearsDOB);
		selectYear.selectByVisibleText(year);
		log.info("Selected year and object is "+selectYear.toString());
		this.address.clear();
		this.address.sendKeys(address);
		this.city.clear();
		this.city.sendKeys(city);
		Select selectState = new Select(State);
		selectState.selectByValue(state);
		this.zipcode.clear();
		this.zipcode.sendKeys(zipcode);
		log.info("Enterted zipcode and object is "+this.zipcode.toString());
		this.mobPhone.sendKeys(mobPhone);
		this.addressAlias.clear();
		this.addressAlias.sendKeys(addressAlias);
		registerButton.click();
		
	}
	
	public boolean AccountCreationVerif()
	{
			if(myAccountTag.isDisplayed())
			{
				log.info("User has successfully logged into his/her account");
				return true;
			}
			else
				return false;		
	}
	
	public void logOutAccount()
	{
		
		//waitForElement(30, logOut);
		logOut.click();
		log.info("Clicked on SignOut button and object is "+logOut.toString());
	}
	
}