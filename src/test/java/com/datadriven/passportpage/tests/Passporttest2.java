package com.datadriven.passportpage.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Passporttest2 {
	
	
	public WebDriver driver;
	@BeforeMethod
	public void setUp(){
		
		driver=new FirefoxDriver();
		driver.get("https://portal1.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@DataProvider
	public Iterator<Object[]> getdatafromexcel(){
		
		ArrayList<Object[]>  mydata = Utility.getDataFromExcel();
		
		return mydata.iterator();
	}
	
	@Test(dataProvider="getdatafromexcel")
	public void fillingtheForm(String givenname, String surname, String dob){
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='dcdrLocation']")));
		select.selectByVisibleText("Hyderabad");
		driver.findElement(By.xpath("//*[@id='givenName']")).sendKeys(givenname);
		driver.findElement(By.xpath("//*[@id='surname']")).sendKeys(surname);
		
		
		
		
	}

}
