package com.datadriven.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil;

public class FreeCRMTest {
	
	public WebDriver driver;
	@BeforeMethod
	public void setUp(){
		
		    WebDriver driver = new FirefoxDriver();
			driver.get("https://www.freecrm.com/index.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		
		ArrayList<Object[]> testData = TestUtil.getdatafromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData")
	public void freeCRMTest(String un, String pwd){
		
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys(un);
		driver.findElement(By.xpath("//*[@type='password']")).clear();
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(pwd);
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
		
	}
	

}
