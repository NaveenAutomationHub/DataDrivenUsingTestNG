package com.datadriven.freecrm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewCompany2 {
	
	public WebDriver driver;
	
	
	@DataProvider
	public Iterator<Object[]> getDataFromExcelforLogin(){
		
		ArrayList<Object[]> testData = TestUtility.getDataforLogin();
		
		
		return testData.iterator();
		
	}
	
	/*@DataProvider
	public Iterator<Object[]> getDataFromExcelforContactsTest(){
		
		
		ArrayList<Object[]> testData1 = TestUtility.getDataForCOntactsTest();
		
		return testData1.iterator();
			}
	*/
	
	/*@DataProvider
	public Iterator<Object[]> mergedTestData(){
		
		
		ArrayList<Object[]> completeData = new ArrayList<Object[]>();
		completeData.addAll();
		completeData.addAll();
		return completeData.iterator();
			}
	*/
	
	@Test(priority=1, dataProvider="getDataFromExcelforLogin")
	
	public void loginTest(String uname, String paswrd){
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(paswrd);
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		
		driver.switchTo().frame("mainpanel");
		
		
		
	}
	
   
	
	
	
	

}
