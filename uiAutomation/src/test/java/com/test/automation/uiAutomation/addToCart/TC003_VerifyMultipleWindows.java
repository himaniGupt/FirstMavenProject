package com.test.automation.uiAutomation.addToCart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;

public class TC003_VerifyMultipleWindows extends TestBase{

	List<String> windowId = new ArrayList<String>();
	
	@BeforeClass
	public void setup() throws IOException
	{
		init();
	}
	
	@Test
	public void verifyMultipleWindows()
	{
		Iterator<String> itr = getAllWindows();
		
		while(itr.hasNext())
		{
			windowId.add(itr.next());
			System.out.println(itr.next());
		}
		
		
		driver.switchTo().window(windowId.get(6));
		driver.switchTo().window(windowId.get(8));
	}
	
//	@AfterClass
//	public void endTest()
//	{
//		closeBrowser();
//	}
	
}
