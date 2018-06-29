package com.excel.utility;

import java.util.ArrayList;

public class TestUtility {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getdatafromExcel(){
		
		ArrayList<Object []>  myData = new ArrayList<Object[]>();
		
		try{
				
		reader = new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/testdata/PassportTestData.xlsx");
		}catch(Exception e){
			
			e.printStackTrace();
		}
		for(int rowNum=2; rowNum<=reader.getRowCount("RegistrationData");rowNum++){
			
			String givenname = reader.getCellData("RegistrationData", "givenName", rowNum);
			String surname = reader.getCellData("RegistrationData", "surName", rowNum);
			String dob = reader.getCellData("RegistrationData", "dob", rowNum);
			String emailid = reader.getCellData("RegistrationData", "emailID", rowNum);
			String loginid = reader.getCellData("RegistrationData", "loginID", rowNum);
			String password = reader.getCellData("RegistrationData", "password", rowNum);
			String confirmpassword = reader.getCellData("RegistrationData", "confirmPassword", rowNum);
			
			
			Object ob[]={givenname,surname,dob,emailid,loginid,password,confirmpassword};
			
			myData.add(ob);
		
		}
		
		return myData;
		
	}

}
