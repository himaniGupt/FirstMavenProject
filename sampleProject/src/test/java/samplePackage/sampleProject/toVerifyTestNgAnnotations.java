package samplePackage.sampleProject;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class toVerifyTestNgAnnotations {
	
	@Test(groups= {"sanity","regression"})
	public void testCase1()
	{
		System.out.println("Test case1 | "+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgAnnotations - Test case1");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups="sanity")
	public void testCase2()
	{
		System.out.println("Test case2 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgAnnotations - Test case2");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups="sanity")
	public void testCase3()
	{
		System.out.println("Test case3 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgAnnotations - Test case3");
	//	System.out.println(Thread.currentThread().getId());
	}
	
	@BeforeClass(groups= {"sanity","regression"})
	public void beforeClassMethod()
	{
		System.out.println("Before class method in Class: toVerifyTestNgAnnotations");
	}
	
	@AfterClass(groups= {"sanity","regression"})
	public void afterClassMethod()
	{
		System.out.println("After class method in Class: toVerifyTestNgAnnotations");
	}
	
	@BeforeTest(groups= {"sanity","regression"})
	public void beforeTest()
	{
		System.out.println("Before test method in Class: toVerifyTestNgAnnotations");
	}
	
	@AfterTest(groups= {"sanity","regression"})
	public void afterTest()
	{
		System.out.println("After test method in Class: toVerifyTestNgAnnotations");
	}
	
	@BeforeMethod(groups= {"sanity","regression"})
	public void beforeMethod()
	{
		System.out.println("Before Method in Class: toVerifyTestNgAnnotations");
	}
	
	@AfterMethod(groups= {"sanity","regression"})
	public void afterMethod()
	{
		System.out.println("After Method in Class: toVerifyTestNgAnnotations");
	}
	
	@BeforeSuite(groups= {"sanity","regression"})
	public void beforeSuite()
	{
		System.out.println("Before Suite in Class: toVerifyTestNgAnnotations");
	}
	
	@AfterSuite(groups= {"sanity","regression"}) void afterSuite()
	{
		System.out.println("After Suite in Class: toVerifyTestNgAnnotations");
	}

}
