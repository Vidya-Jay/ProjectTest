package retesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_write {

	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\Sample.xlsx";
		File f=new File(path);
		FileInputStream fi= new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheetAt(0);
		int rc=sh.getLastRowNum();
		XSSFRow r=sh.getRow(0);
		int cc= r.getLastCellNum();
		System.out.println("no of rows are::"+rc+"  "+"no of columns are::"+cc);
		String user= sh.getRow(1).getCell(0).getStringCellValue();
		String pass=sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println(user+"  "+pass);
		//write some text into result column
		sh.getRow(1).createCell(2).setCellValue("testing");
		fi.close();
		//FileOutputStream fo=new FileOutputStream(f);
		//write into new file
		FileOutputStream fo=new FileOutputStream(new File("C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\Results.xlsx"));
		wb.write(fo);
		fo.close();
		wb.close();
		

	}

}
