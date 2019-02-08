package com.test.automation.uiAutomation.MiscLearning;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.MiscLearningJava.HandleWebTable;
import com.test.automation.uiAutomation.testBase.TestBase;

public class TC006_HandleWebTable extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC006_HandleWebTable.class.getName());
	HandleWebTable handlewebtable;
	
	@BeforeTest
	public void setup() throws IOException
	{
		
		init();
		
	}
	
	@Test
	public void getWebTable()
	{
		handlewebtable = new HandleWebTable(driver);
		getUrl(OR.getProperty("webTableUrl"));
		handlewebtable.fetchWebTable();
	}

}

