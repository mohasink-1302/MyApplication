package com.myapplication.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;

public class ProductPage extends TestBase{
	
	@FindBy(xpath="//a[@title='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath="//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']")
	WebElement clickOnProduct;
	 
	public ProductPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public ProceedToCheckOutPage addToCartProduct()
	{
		addToCart.click();
		return new ProceedToCheckOutPage();
	}
	
	public AddToCartPage clickOnProduct()
	{
		clickOnProduct.click();
		return new AddToCartPage();
	}
	
}
