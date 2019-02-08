package samplePackage.sampleProject2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class toVerifyTestNgAnnotations2 {

	@Test(groups="regression")
	public void toVerifyTestNgAnnotations2TestCase1()
	{
		System.out.println("toVerifyTestNgAnnotations2: Test case1 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgAnnotations2 - Test case1");
		//System.out.println(Thread.currentThread().getId());
//		WebDriver driver = new FirefoxDriver();
//		Actions crop = new Actions(driver);
//		WebElement cropTracker = null;
//		crop.clickAndHold(cropTracker).moveByOffset(30, 50).release().build().perform();
	}
	
	@Test(groups="regression")
	public void toVerifyTestNgAnnotations2TestCase2()
	{
		System.out.println("toVerifyTestNgAnnotations2: Test case2 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgAnnotations2 - Test case2");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups="sanity")
	public void toVerifyTestNgAnnotations2TestCase3()
	{
		System.out.println("toVerifyTestNgAnnotations2: Test case3 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgAnnotations2 - Test case3");
		//System.out.println(Thread.currentThread().getId());
	}
}
