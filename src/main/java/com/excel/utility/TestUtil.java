package com.excel.utility;

import java.util.ArrayList;

public class TestUtil {
	
	public static ArrayList<Object[]> getdatafromExcel(){
		
		ArrayList<Object []>  myData = new ArrayList<Object[]>();
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/testdata/HalfEBayTestData.xlsx");
		
		for(int rowNum=2; rowNum<=reader.getRowCount("RegTestData");rowNum++){
			
			String un = reader.getCellData("RegTestData", "username", rowNum);
			
			String pwd = reader.getCellData("RegTestData", "password", rowNum);
			
			Object ob[]={un,pwd};
			
			myData.add(ob);
		
		}
		
		return myData;
		
	}

}
