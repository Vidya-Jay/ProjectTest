package retesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_All {

	public static void main(String[] args) {
		//read data from excel
		try {
		FileInputStream fi=new FileInputStream("C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\Sample.xlsx");
		
				//create object for workbook
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet sh=wb.getSheetAt(0);
		//count no of rows in a sheet
		int rc=sh.getLastRowNum();
		//get row from sheet
		XSSFRow r=sh.getRow(0);
		//count no of columns in a row
		int cc= r.getLastCellNum();
		System.out.println("no of rows::"+rc+"  "+"no of columns::"+cc);
		for(int i=1;i<=rc;i++)
		{
			//get first column from sheet
			String username= sh.getRow(i).getCell(0).getStringCellValue();
			//get second column from sheet
			String password=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+password);
			
		}
		fi.close();
		
			wb.close();
		} catch (Throwable t) {
			
			System.out.println(t.getMessage());
		}
		

	}

}
