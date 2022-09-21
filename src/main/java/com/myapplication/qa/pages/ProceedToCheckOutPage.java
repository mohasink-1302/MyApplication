package com.myapplication.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;

public class ProceedToCheckOutPage extends TestBase {
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement checkout;
	
	@FindBy(xpath="//span[contains(text(),'Your shopping cart contains:')and text()]//span[contains(text(),'1 Product')]")
	WebElement checkoutproduct;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement nextpage;
	

	public ProceedToCheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProceedToCheckOutPage verifyTheProduct()
	{
		checkout.click();
		return new ProceedToCheckOutPage();
	}
	
	public String verifyProductAddedToCart()
	{
		return checkoutproduct.getText();
	}
	
	public AddressPage proceedToAddress()
	{
		nextpage.click();
		return new AddressPage();
	}
	
}
