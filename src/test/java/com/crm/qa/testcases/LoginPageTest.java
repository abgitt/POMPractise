package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpg;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpg = new LoginPage(); 
	}
	
	
	@Test
	public void loginPageTest()
	{
		Assert.assertEquals(loginpg.getTitle(), "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void crmLogoTest()
	{
		Assert.assertTrue(loginpg.validateLogo());
	}
	
	@Test
	public void loginTest()
	{
		homepage = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
	
}
