package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage lpg;
	HomePage hpg;
	ContactsPage cpg;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		lpg = new LoginPage();
		hpg = lpg.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame("mainpanel");
		cpg = hpg.clickOnContactsLink();
	}
	
	@Test(priority=2)
	public void verifyContactsPageTest()
	{
		Assert.assertTrue(cpg.verifyContactslbl());
	}
	
	@Test(priority=1)
	public void selctContactTest()
	{
		cpg.selectContactsByName("Mamatha G");
	}
	
	@DataProvider
	public Object[][] getCRMtestData()
	{
		return TestUtil.getTestData("Contacts");
	}
	
	
	@Test(priority=4,dataProvider="getCRMtestData")
	public void createNewContactTest(String title,String fname,String lname,String co)
	{
		hpg.clickNewContact();
		//cpg.createNewContact("Dr.", "Abilash", "G", "IR");
		cpg.createNewContact(title, fname, lname, co);
	}
	
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
}
