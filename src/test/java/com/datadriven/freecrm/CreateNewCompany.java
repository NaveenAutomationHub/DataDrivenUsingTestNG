package com.datadriven.freecrm;

import java.util.ArrayList;
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

public class CreateNewCompany {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("naveendommata");
		driver.findElement(By.name("password")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		
		 driver.switchTo().frame("mainpanel");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	}
	
	/*@DataProvider
	public Iterator<Object[]> getDataFromExcelforLogin(){
		
		ArrayList<Object[]> testData = TestUtility.getDataforLogin();
		
		
		return testData.iterator();
		
	}
	*/
	@DataProvider
	public Iterator<Object[]> getDataFromExcelforContactsTest(){
		
		
		ArrayList<Object[]> testData1 = TestUtility.getDataForCOntactsTest();
		
		return testData1.iterator();
			}
	
	/*@Test(priority=1, dataProvider="getDataFromExcelforLogin")
	
	public void loginTest(String uname, String paswrd){
		
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(paswrd);
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		
		driver.switchTo().frame("mainpanel");
		
		
	}*/
	
   @Test(dataProvider="getDataFromExcelforContactsTest")
	
	public void ContactsTest(String firstname, String lastname, String middlename) throws InterruptedException{
		
	  
		
		WebElement e1 = driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a"));
		
		WebElement e2 = driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/ul/li[1]/a"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(e1).build().perform();
		
		Thread.sleep(3000);
		actions.moveToElement(e2).click().build().perform();
		
		
		driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//*[@id='surname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id='middle_initial']")).sendKeys(middlename);
	}
	
	
	
	

}
