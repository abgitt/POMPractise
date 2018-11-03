package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'User: Abilash')]")
	WebElement usernamelbl;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslnk;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslnk;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslnk;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslnk;
	
	public HomePage()
	{
		PageFactory.initElements(dr, this);
	}
	
	public String verifyHomePageTitile()
	{
		return dr.getTitle();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactslnk.click();
		return new ContactsPage();
	}
	
	public void clickNewContact()
	{
		Actions act = new Actions(dr);
		act.moveToElement(contactslnk).build().perform();
		act.click(newcontactslnk).build().perform();
	}
	
	public boolean verifyCorrectUserName()
	{
		return usernamelbl.isDisplayed();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealslnk.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		taskslnk.click();
		return new TasksPage();
	}
}
