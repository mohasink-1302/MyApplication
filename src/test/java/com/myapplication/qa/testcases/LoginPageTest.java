package com.myapplication.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myapplication.qa.base.TestBase;
import com.myapplication.qa.pages.LoginPage;
import com.myapplication.qa.pages.MyAccountPage;

public class LoginPageTest extends TestBase{
	LoginPage LoginPage;
	MyAccountPage MyAccountPage;
	
	LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp()
	{
		intialization();
		LoginPage = new LoginPage();
	}
	
	@Test(priority = 2)
	public void verifylogo()
	{
		boolean flag = LoginPage.verifyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 1)
	public void verifyTitle()
	{
		String title = LoginPage.verifyTitlePage();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority = 3)
	public void login()
	{
		MyAccountPage = LoginPage.login();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
