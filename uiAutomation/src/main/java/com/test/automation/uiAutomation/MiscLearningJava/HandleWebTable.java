package com.test.automation.uiAutomation.MiscLearningJava;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class HandleWebTable extends TestBase{
	
	@FindBy(xpath="//table[@class='dataTable']/thead/tr")
	List <WebElement> topGainersTableHeadRow;
	
	@FindBy(xpath="//table[@class='dataTable']/tbody/tr")
	List <WebElement> topGainersTableRows;
	
	@FindBy(xpath="//table[@class='dataTable']/tbody/tr[1]/td")
	List <WebElement> topGainersTableFirstRowsCols;
	
	@FindBy(xpath="//table[@class='dataTable']/tbody/tr/td")
	List <WebElement> topGainersTableCells;
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	public HandleWebTable(EventFiringWebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void fetchWebTable()
	{
		List <WebElement> TableDataRows = topGainersTableRows;
		List <WebElement> TableDataFirstRowCols = topGainersTableFirstRowsCols;
		int RowCount = TableDataRows.size();
		int ColCount = TableDataFirstRowCols.size();
		List <WebElement> TableHeader = topGainersTableHeadRow;
		
		for(WebElement ele:TableHeader)
		{
			System.out.println(ele.getText());
			
		}
		
//		for(WebElement row:topGainersTableRows)
//		{
//			System.out.println(row.getText());
//		}
		System.out.println("Row count:- "+RowCount);
		System.out.println("Col count:- "+ColCount);
		
		for(int i=1; i<=RowCount; i++)
		{
			for(int j=i;j<=ColCount+i-1;j++)
			{
				System.out.print(topGainersTableCells.get(j).getText()+" ");
			}
			System.out.println();
		}
		
		
		
	}
}
