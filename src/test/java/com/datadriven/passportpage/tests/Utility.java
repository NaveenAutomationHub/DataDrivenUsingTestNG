package com.datadriven.passportpage.tests;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class Utility {
	
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/testdata/PassportTestData.xlsx");
		
		String givenname = reader.getCellData("RegistrationData", "givenName", 2);
		String surname = reader.getCellData("RegistrationData", "surName", 2);
		String dob = reader.getCellData("RegistrationData", "dob", 2);
		
		Object ob[] ={givenname, surname, dob};
		
		myData.add(ob);
		
		return myData;
	}

}
