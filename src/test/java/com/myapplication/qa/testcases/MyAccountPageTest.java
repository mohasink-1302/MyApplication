package com.myapplication.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myapplication.qa.base.TestBase;
import com.myapplication.qa.pages.LoginPage;
import com.myapplication.qa.pages.MyAccountPage;
import com.myapplication.qa.pages.ProductPage;
import com.myapplication.qa.util.TestUtil;

public class MyAccountPageTest extends TestBase{
	
	LoginPage LoginPage;
	MyAccountPage MyAccountPage;
	ProductPage ProductPage;
	
	MyAccountPageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp()
	{
		intialization();
		LoginPage = new LoginPage();
		MyAccountPage = LoginPage.login();
		MyAccountPage = new MyAccountPage();
		ProductPage = new ProductPage();
	}

	@Test
	public void searchProduct() throws InvalidFormatException, IOException
	{
		ProductPage = MyAccountPage.searchProduct(TestUtil.getData(0, 0));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
