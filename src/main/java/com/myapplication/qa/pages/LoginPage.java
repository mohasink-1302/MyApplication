package com.myapplication.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//img[contains(@class,'logo img-responsive')]")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signinBTN;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement pwd;

	@FindBy(xpath="//button[contains(@name,'SubmitLogin')]")
	WebElement submit;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public String verifyTitlePage()
	{
		return driver.getTitle();
	}
	
	public MyAccountPage login()
	{
		Actions act = new Actions(driver);
		act.moveToElement(signinBTN).click().build().perform();;
		username.sendKeys(prop.getProperty("username"));
		pwd.sendKeys(prop.getProperty("password"));
		submit.click();
		return new MyAccountPage();
	}
}
