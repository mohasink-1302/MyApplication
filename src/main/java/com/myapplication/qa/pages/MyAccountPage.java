package com.myapplication.qa.pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;
import com.myapplication.qa.util.TestUtil;

public class MyAccountPage extends TestBase{
	
	@FindBy(xpath="//input[contains(@name,'search_query')]")
	WebElement search;
	
	@FindBy(xpath="//button[contains(@name,'submit_search')]")
	WebElement searchBTN;
	
	
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public ProductPage searchProduct(String name) throws InvalidFormatException, IOException
	{
		search.sendKeys(name);
		searchBTN.click();
		return new ProductPage();
	}
}
