package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslbl;
	
	@FindBy(name="title")
	WebElement title_we;

	@FindBy(id="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[contains(@type,'submit')][@value='Save']") //with contains function //input[contains(@type,'submit') and contains(@value,'Save')]
	WebElement submit;
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
	
	public void createNewContact(String title,String fname,String lname,String co)
	{
		Select title_slct = new Select(title_we);
		title_slct.selectByVisibleText(title);
		
		first_name.sendKeys(fname);
		surname.sendKeys(lname);
		company.sendKeys(co);
		submit.click();
		
	}
}
