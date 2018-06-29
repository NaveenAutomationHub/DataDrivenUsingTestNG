package com.datadriven.passportpage.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.excel.utility.TestUtility;

public class PassportTest {
	
	public WebDriver driver;
	@BeforeMethod
	public void setUp(){
		
		    driver = new FirefoxDriver();
			driver.get("https://portal1.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		
		ArrayList<Object[]> testData = TestUtility.getdatafromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData")
	public void freeCRMTest(String givenname, String surname, String dob, String emailid,
			String loginID, String password, String confirmpassword){
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='dcdrLocation']")));
		select.selectByVisibleText("Hyderabad");
		driver.findElement(By.xpath("//*[@id='givenName']")).sendKeys(givenname);
		driver.findElement(By.xpath("//*[@id='surname']")).sendKeys(surname);
		//driver.findElement(By.xpath("//*[@id='dob']")).sendKeys(dob);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id='loginId']")).sendKeys(loginID);
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmPwd']")).sendKeys(confirmpassword);
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
		
	}
	

}
