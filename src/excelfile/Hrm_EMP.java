package excelfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pack1.Reusable;

public class Hrm_EMP extends Reusable{
 public static File f;
 public static FileInputStream fi;
 public static XSSFWorkbook wb;
 public static XSSFSheet sh;
 public static XSSFRow r;
 public static FileOutputStream fo;
 public static Actions ac;
 
 
 
 @BeforeTest
 
 public void Admin_Login(){
	 driver=new ChromeDriver();
	 driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
	 driver.manage().window().maximize();
	 driver.findElement(By.cssSelector("#txtUsername")).sendKeys(Keys.DOWN,"Admin",Keys.UP);
	 driver.findElement(By.cssSelector("#txtPassword")).sendKeys(Keys.DOWN,"admin",Keys.UP);
	 driver.findElement(By.cssSelector("#btnLogin")).sendKeys(Keys.ENTER);
	 

}
 
 @Test
 public void Verify_Empcration() throws IOException, InterruptedException{
	ac=new Actions(driver);
	 //read file
	 String excelpath= "C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\empcreation.xlsx";
	 String outpath="C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\empresults.xlsx";
	 f=new File(excelpath);
	fi= new FileInputStream(f);

	//create workbook
	wb=new XSSFWorkbook(fi);
	
	//get the sheet from workbook
	sh=wb.getSheetAt(0);
	
	//count no of rows
	int rc=sh.getLastRowNum();
	
	//get first row from sheet
	r=sh.getRow(0);
	
	//count no of columns from Row
	int cc=r.getLastCellNum();
	
	Reporter.log("no of rows::"+rc+" "+"no of columns are::"+cc,true);
	
	//iterate all rows
	int i=1;//start from second row
	
	while(i<=rc)
	{
		//fill employee form
		ac.moveToElement(driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b"))).click().perform();
		Thread.sleep(5000);
		ac.moveToElement(driver.findElement(By.id("btnAdd"))).click().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='middleName']")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(sh.getRow(i).getCell(2).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='employeeId']")).clear();
		driver.findElement(By.xpath("//*[@id='employeeId']")).sendKeys(sh.getRow(i).getCell(3).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='btnSave']")).sendKeys(Keys.ENTER);
		String url=driver.getCurrentUrl();
		if(url.contains("empNumber"))
		{
			Reusable.screenshotWithDate("online//screen//", "empcreation");
			Reporter.log("Emp creation is successful",true);
			
			//write into results
			sh.getRow(i).createCell(4).setCellValue("Emp creation is success");
				
			
		}
		else{
			Reusable.screenshotWithDate("online//screen//", "empcreation");
			Reporter.log("Emp creation is not successful",true);
			
			//write into results
			sh.getRow(i).createCell(4).setCellValue("Emp creation is unscuccess");
		}
		
		i=i+1;
	}
	
	 fi.close();
	 fo=new FileOutputStream(new File(outpath));
	 wb.write(fo);
	 fo.close();
	 wb.close();
	 
 }
 @AfterTest
 public void Logout() throws InterruptedException{
	 Thread.sleep(5000);
	 driver.quit();
	 
 }
}
