package samplePackage.sampleProject;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class toVerifyTestNgMoreAnnotations {

	@Test(groups="sanity")
	public void testCase1()
	{
		System.out.println("toVerifyTestNgMoreAnnotations: Test case1 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgMoreAnnotations - Test case1");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups="regression")
	public void testCase2()
	{
		System.out.println("toVerifyTestNgMoreAnnotations: Test case2 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgMoreAnnotations - Test case2");
		//System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void testCase3()
	{
		System.out.println("toVerifyTestNgMoreAnnotations: Test case3 |"+Thread.currentThread().getId());
		Reporter.log("toVerifyTestNgMoreAnnotations - Test case3");
		//System.out.println(Thread.currentThread().getId());
	}
	
}
