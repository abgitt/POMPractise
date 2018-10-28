package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver dr;
	public static Properties prop;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\ABI\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com"
					+"\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			dr=new ChromeDriver();	
		}
		else if(prop.getProperty("browser").equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			dr=new ChromeDriver();	
		}
		
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		dr.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		
		dr.get(prop.getProperty("url"));
	}
	
}
