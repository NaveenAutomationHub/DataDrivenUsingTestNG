package com.datadriven.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader;

public class ParametrizedTest {

	public static void main(String[] args) {
		
		 WebDriver driver = new FirefoxDriver();
			driver.get("https://www.freecrm.com/index.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/testdata/HalfEBayTestData.xlsx");
		
		int rowCount = reader.getRowCount("RegTestData");
		reader.addColumn("RegTestData", "Status");
		
		for(int rowNum=2; rowNum<=rowCount;rowNum++){
			
		String str = reader.getCellData("RegTestData", "username", rowNum);
		
		System.out.println(str);
		
		String str1 = reader.getCellData("RegTestData", "password", rowNum);
		
		System.out.println(str1);
		
			driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).clear();
			driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys(str);
			driver.findElement(By.xpath("//*[@type='password']")).clear();
			driver.findElement(By.xpath("//*[@type='password']")).sendKeys(str1);
			//driver.findElement(By.xpath("//*[@type='submit']")).submit();			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");
		
			
			reader.addSheet("HomePage");
			
			int coloumnCount = reader.getColumnCount("RegTestData");
			int rowcnt = reader.getRowCount("RegTestData");
			
			System.out.println(coloumnCount);
			System.out.println(rowcnt);
		}

	}

}
