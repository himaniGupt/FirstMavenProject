package samplePackage.sampleProject;

import org.testng.annotations.Test;

public class toVerifyTestNgMoreAnnotations {

	@Test(groups="sanity")
	public void testCase1()
	{
		System.out.println("toVerifyTestNgMoreAnnotations: Test case1");
	}
	
	@Test(groups="regression")
	public void testCase2()
	{
		System.out.println("toVerifyTestNgMoreAnnotations: Test case2");
	}
	
	@Test
	public void testCase3()
	{
		System.out.println("toVerifyTestNgMoreAnnotations: Test case3");
	}
	
}
