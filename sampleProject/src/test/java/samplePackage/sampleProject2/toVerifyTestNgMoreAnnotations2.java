package samplePackage.sampleProject2;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class toVerifyTestNgMoreAnnotations2 {

	@Test(groups= {"regression","smoke"})
	public void toVerifyTestNgAnnotations2TestCase1()
	{
		System.out.println("toVerifyTestNgMoreAnnotations2: Test case1 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgMoreAnnotations2 - Test case1");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void toVerifyTestNgAnnotations2TestCase2()
	{
		System.out.println("toVerifyTestNgMoreAnnotations2: Test case2 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgMoreAnnotations2 - Test case2");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups="sanity")
	public void toVerifyTestNgAnnotations2TestCase3()
	{
		System.out.println("toVerifyTestNgMoreAnnotations2: Test case3 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgMoreAnnotations2 - Test case3");
	//	System.out.println(Thread.currentThread().getId());
	}
}
