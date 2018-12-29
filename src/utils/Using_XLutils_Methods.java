package utils;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Using_XLutils_Methods {

	@Test
	public void xlmethods() throws IOException{
		//create reference object for xlutils class
		XLUtils excel=new XLUtils();
		String excelpath="C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\Sample.xlsx";
		//count no of rows
		int rc=excel.getRowCount(excelpath, "Login");
		//count no of columns
		int cc=excel.getCellCount(excelpath, "Login", 0);
		System.out.println("no of rows::"+rc+"  "+"no of cols::"+cc);
		for (int i=1;i<=rc;i++){
			//get second row and first column value
			String username= excel.getCellData(excelpath, "Login", i, 0);
			String password=excel.getCellData(excelpath, "Login", i, 1);
			System.out.println(username+"  "+password);
			//write some text in result column
			excel.setCellData(excelpath, "Login", i, 2, "Passed");
		}
	
	}
	@AfterTest
	public void logout(){
		
	}	
	
	
}
