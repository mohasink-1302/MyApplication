package com.myapplication.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myapplication.qa.base.TestBase;
import com.myapplication.qa.pages.AddToCartPage;
import com.myapplication.qa.pages.LoginPage;
import com.myapplication.qa.pages.MyAccountPage;
import com.myapplication.qa.pages.ProceedToCheckOutPage;
import com.myapplication.qa.pages.ProductPage;
import com.myapplication.qa.util.TestUtil;

public class ProductPageTest extends TestBase {
	
	LoginPage LoginPage;
	MyAccountPage MyAccountPage;
	ProductPage ProductPage;
	AddToCartPage AddToCartPage;

	ProductPageTest()
	{
		super();
	}
	

	@BeforeMethod 
	public void setUp() throws InvalidFormatException, IOException
	{
		intialization();
		LoginPage = new LoginPage();
		MyAccountPage = LoginPage.login();
		MyAccountPage = new MyAccountPage();
		ProductPage = MyAccountPage.searchProduct(TestUtil.getData(0, 0));
		ProductPage = new ProductPage();
	}
	
	@Test
	public void productAddToCart()
	{
		AddToCartPage = ProductPage.clickOnProduct();
	}

	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}

}
