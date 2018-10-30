package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslbl;
	
	public ContactsPage()
	{
		PageFactory.initElements(dr, this);
	}
	
	public boolean verifyContactslbl()
	{
		return contactslbl.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		dr.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input")).click();

	}
}
