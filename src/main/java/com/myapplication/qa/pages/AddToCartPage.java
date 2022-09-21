package com.myapplication.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;

public class AddToCartPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCart;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public ProceedToCheckOutPage addToCartProduct()
	{
		addToCart.click();
		return new ProceedToCheckOutPage();
	}

	
}
