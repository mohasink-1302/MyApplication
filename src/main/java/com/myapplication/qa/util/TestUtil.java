package com.myapplication.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.myapplication.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static String getData(int i, int j) throws InvalidFormatException, IOException {
		String path = "E:\\Velocity-feb-2022\\MyApplication\\src\\"
				+ "main\\java\\com\\myapplication\\qa\\testdata\\MyApplicationData.xlsx";

		FileInputStream file = new FileInputStream(path);

		Sheet data = WorkbookFactory.create(file).getSheet("Cloaths");

		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(data.getRow(i).getCell(j));

		return val;
	}

	
//	public static void captureScreenshot(WebDriver driver, String FileName)
//	  throws IOException {
//	  
//	  File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	  
//	  //File dest = new File("path");
//	  
//	  //FileHandler.copy(file, dest);
//	  
//	  //Files.copy(file, new File("E:\\Velocity-feb-2022\\SeleniumJava\\src\\Screenshot\\"+FileName+".jpg"));
//	  
//	  Files.copy(file, new File("E:\\Velocity-feb-2022\\MyApplication\\ScreenShot"+FileName+".jpg")); } 
	 
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		Files.copy(scrFile, new File(currentDir + "/ScreenShot/" + System.currentTimeMillis() + ".png"));
	}

}
