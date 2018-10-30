package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginpg;
	HomePage homepg;
	ContactsPage contactpg;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpg = new LoginPage();
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		Assert.assertEquals(homepg.verifyHomePageTitile(), "CRMPRO","Homepage title is not matched.");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		TestUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homepg.verifyCorrectUserName());
		
	}
	@Test(priority=3)
	public void verifyContactsLink()
	{
		TestUtil.switchToFrame("mainpanel");
		contactpg = homepg.clickOnContactsLink();
	}
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
}
