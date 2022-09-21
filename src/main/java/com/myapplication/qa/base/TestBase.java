package com.myapplication.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.myapplication.qa.util.TestUtil;
import com.myapplication.qa.util.WebEventListener;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase()
	{
		//reading property file 
		try {
		prop = new Properties();
		FileInputStream fs = new FileInputStream("E:\\Velocity-feb-2022\\MyApplication\\src\\main"
				+ "\\java\\com\\myaplication\\qa\\config\\config.properties");
		prop.load(fs);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//launching browser
	public static void intialization()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\FAIZAN\\OneDrive\\Desktop\\Software-Testing Material\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\FAIZAN\\OneDrive\\Desktop\\Software-Testing Material\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);//taking value from test util class
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);//taking value from test util class
		
		driver.get(prop.getProperty("url"));
	}


}
