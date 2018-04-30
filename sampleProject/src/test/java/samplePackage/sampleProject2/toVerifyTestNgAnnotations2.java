package samplePackage.sampleProject2;

import org.testng.annotations.Test;

public class toVerifyTestNgAnnotations2 {

	@Test(groups="regression")
	public void toVerifyTestNgAnnotations2TestCase1()
	{
		System.out.println("toVerifyTestNgAnnotations2: Test case1");
	}
	
	@Test(groups="regression")
	public void toVerifyTestNgAnnotations2TestCase2()
	{
		System.out.println("toVerifyTestNgAnnotations2: Test case2");
	}
	
	@Test(groups="sanity")
	public void toVerifyTestNgAnnotations2TestCase3()
	{
		System.out.println("toVerifyTestNgAnnotations2: Test case3");
	}
}
