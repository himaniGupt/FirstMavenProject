package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public String cellText;
	
	public Excel_Reader(String path)
	{
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public String[][] getDataFromSheet(String sheetname, String excelName)
	{
		String dataSets[][] = null;
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int totalRow = sheet.getLastRowNum()+1;
		int totalColumn = sheet.getRow(0).getLastCellNum();
		dataSets = new String[totalRow-1][totalColumn];
		
		for(int i=1;i<totalRow;i++)
		{
			XSSFRow rows = sheet.getRow(i);
			for(int j=0;j<totalColumn;j++)
			{
				XSSFCell cell = rows.getCell(j);
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
					dataSets[i-1][j]=cell.getStringCellValue();
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					cellText = String.valueOf(cell.getNumericCellValue());
					dataSets[i-1][j]=cellText;
				}else
					dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				
			}
		}
		return dataSets;
		
	}
}
