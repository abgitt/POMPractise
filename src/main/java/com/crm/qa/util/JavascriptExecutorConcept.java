package com.crm.qa.util;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//Java Script executor
public class JavascriptExecutorConcept {
		public static void main(String args[]) throws InterruptedException, IOException
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver dr = new ChromeDriver();
			dr.manage().window().maximize();
			dr.manage().deleteAllCookies();
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			dr.manage().deleteAllCookies();
			dr.navigate().to("https://www.freecrm.com/");

			dr.findElement(By.name("username")).sendKeys("naveenk");
			dr.findElement(By.name("password")).sendKeys("test@123");
			WebElement element = dr.findElement(By.xpath("//input[@type='submit' and @value='Login']"));
			Thread.sleep(5000);
			dr.switchTo().parentFrame();
			JavascriptExecutor js = ((JavascriptExecutor)dr);

//			flash(dr.findElement(By.name("username")),dr,js);
			drawBorder(dr, element, js);
			File image = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image,new File("C:\\Users\\ABI\\Desktop\\Error1.jpg"));
			generateAlert(dr, "Working perfect", js);
			Alert al = dr.switchTo().alert();
			al.accept();
			//clickElement(dr, element, js);
			refresh(js);
			System.out.println(getTitle(js));
			System.out.println(getPageInnerText(js));
			//scrollPageDown(js);
			scrollInto(js,dr.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")));
			dr.switchTo().parentFrame();
			//dr.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
			clickElement(dr, dr.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")), js);
			}
		
		public static void scrollPageDown(JavascriptExecutor js)
		{
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		
		public static void scrollInto(JavascriptExecutor js,WebElement element)
		{
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		
		public static String getTitle(JavascriptExecutor js)
		{
			return js.executeScript("return document.title;").toString();
		}
		
		public static String getPageInnerText(JavascriptExecutor js)
		{
			return js.executeScript("return document.documentElement.innerText;").toString();
		}
		
		public static void flash(WebElement element,WebDriver dr,JavascriptExecutor js)
		{
			//JavascriptExecutor js = ((JavascriptExecutor)dr);
			String bgcolor= element.getCssValue("backgroundColor");
			for(int i=0;i<10;i++)
			{
				changeColor(dr,element,"rgb(200,200,0)",js);
				changeColor(dr,element,bgcolor,js);
			}
		}
		
		public static void changeColor(WebDriver dr,WebElement element,String color,JavascriptExecutor js)
		{
			js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
		}
		
		public static void drawBorder(WebDriver dr,WebElement element,JavascriptExecutor js)
		{
			js.executeScript("arguments[0].style.border = '3px dotted red'", element);
		}
		
		public static void generateAlert(WebDriver dr,String msg,JavascriptExecutor js)
		{
			js.executeScript("alert('"+msg+"')");
		}
		
		public static void clickElement(WebDriver dr,WebElement element,JavascriptExecutor js)
		{
			js.executeScript("arguments[0].click();",element);
		}
		
		public static void changeDate(String val,WebElement element,JavascriptExecutor js)
		{
			js.executeScript("document.getElementById('ctl00_mainContent_view_date1').value='"+val+"';");
		}
		
		public static void refresh(JavascriptExecutor js)
		{
			js.executeScript("history.go(0)");
		}
}