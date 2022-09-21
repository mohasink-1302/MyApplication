package com.myapplication.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;

public class AddressPage extends TestBase{

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement page;
	
	public AddressPage()
	{
		PageFactory.initElements(driver,this);
	}
	
}
