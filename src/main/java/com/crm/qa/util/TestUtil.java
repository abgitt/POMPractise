package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIME_OUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	static String TEST_DATA = "C:\\Users\\ABI\\eclipse-workspace\\FreeCRMTest\\src\\main"
			+"\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static void switchToFrame(String fr)
	{
		dr.switchTo().frame(fr);
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		try
		{
			book = WorkbookFactory.create(new FileInputStream(TEST_DATA));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
}
