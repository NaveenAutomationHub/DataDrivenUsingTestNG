package com.datadriven.tests;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader;


public class DataDrivenTest {

	public static void main(String[] args) {
		
		//driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys("naveendommata");;
		//
		//driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Welcome@123");;
		
		//driver.findElement(By.xpath("//*[@type='submit']")).submit();
		
		//driver.switchTo().frame("mainpanel");
		//driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a")).click();
		
		//String filepath = System.getProperty("user.dir")+"src/main/java/com/testdata/HalfEBayTestData.xlsx";
	
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/testdata/HalfEBayTestData.xlsx");
		
			
						String un = reader.getCellData("RegTestData", "username", 2);
						String pwd = reader.getCellData("RegTestData", "password", 2);
						
			        WebDriver driver = new FirefoxDriver();
					driver.get("https://www.freecrm.com/index.html");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys(un);
					driver.findElement(By.xpath("//*[@type='password']")).sendKeys(pwd);
					driver.findElement(By.xpath("//*[@type='submit']")).submit();
					
					
					driver.switchTo().frame("mainpanel");
					driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a")).click();
					
					String name = reader.getCellData("ContactsData", "name", 2);
					
					String company =reader.getCellData("ContactsData", "company", 2);
					
					String emailname = reader.getCellData("ContactsData", "email", 2);
					
					//driver.switchTo().frame("mainpanel");
					
					
					driver.findElement(By.xpath("//*[@type='text' and @name='cs_name']")).sendKeys(name);
					driver.findElement(By.xpath("//*[@id='extendedSearchLayer']/table/tbody/tr[2]/td[1]/table/tbody/tr[4]/td[2]/input")).sendKeys(company);
					driver.findElement(By.xpath("//*[@id='extendedSearchLayer']/table/tbody/tr[2]/td[1]/table/tbody/tr[5]/td[2]/input")).sendKeys(emailname);
		

	}

}
