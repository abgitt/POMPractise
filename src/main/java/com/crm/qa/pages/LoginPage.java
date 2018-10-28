package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
	//1.Page factory -- OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//2.initializing page objects

	public LoginPage()
	{
		PageFactory.initElements(dr, this);
	}
	
	//3. Actions
	
	public String getTitle()
	{
		return dr.getTitle();
	}
	
	public boolean validateLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		
		username.sendKeys(String.valueOf(un));
		password.sendKeys(String.valueOf(pwd));
		JavascriptExecutor js = ((JavascriptExecutor)dr);
		js.executeScript("arguments[0].click();",loginBtn);		
		return new HomePage();
	}
}
