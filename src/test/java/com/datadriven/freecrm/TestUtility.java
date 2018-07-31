package com.datadriven.freecrm;

import java.util.ArrayList;

public class TestUtility {
	
	
	public static ArrayList<Object[]> getDataforLogin(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/test/java/com/datadriven/freecrm/FreeCRMTest.xlsx");
		
		for(int rowNum=2; rowNum<=reader.getRowCount("LoginData"); rowNum++){
			
			String uname = reader.getCellData("LoginData", "username", rowNum);
			
			String paswrd = reader.getCellData("LoginData", "password", rowNum);
			
			Object ob[] ={uname,paswrd};
			
			myData.add(ob);
			
		}
		
		return myData;
		
	}
	
	
	public static ArrayList<Object[]> getDataForCOntactsTest(){
		
		
ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/test/java/com/datadriven/freecrm/FreeCRMTest.xlsx");
		
		for(int rowNum=2; rowNum<=reader.getRowCount("ContactsData"); rowNum++){
			
			String firstname = reader.getCellData("ContactsData", "firstname", rowNum);
			
			String lastname = reader.getCellData("ContactsData", "lastname", rowNum);
			String middlename = reader.getCellData("ContactsData", "middlename", rowNum);
			
			Object ob[] ={firstname,lastname,middlename};
			
			myData.add(ob);
			
		}
		
		return myData;
		
	}

}
