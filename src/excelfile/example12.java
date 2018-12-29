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



public class example12 {
	public static WebDriver driver;
	public static Actions ac;
	public static File f;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow r;
	

	public static void main(String[] args) throws InterruptedException, IOException {
		 driver=new ChromeDriver();
		 driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
		 driver.manage().window().maximize();
		 driver.findElement(By.cssSelector("#txtUsername")).sendKeys(Keys.DOWN,"Admin",Keys.UP);
		 driver.findElement(By.cssSelector("#txtPassword")).sendKeys(Keys.DOWN,"admin",Keys.UP);
		 driver.findElement(By.cssSelector("#btnLogin")).sendKeys(Keys.ENTER);
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
		
		for(int i=1;i<=rc;i++){
			driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("btnAdd")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//*[@id='middleName']")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(sh.getRow(i).getCell(2).getStringCellValue());
			driver.findElement(By.xpath("//*[@id='employeeId']")).sendKeys(sh.getRow(i).getCell(3).getStringCellValue());
			driver.findElement(By.xpath("//*[@id='btnSave']")).sendKeys(Keys.ENTER);
			String url=driver.getCurrentUrl();
			if(url.contains("empnumber"))
			{
		
				System.out.println("Emp creation is successful");
				
				//write into results
				sh.getRow(i).createCell(4).setCellValue("Emp creation is success");
					
				
			}
			else{
		
				System.out.println("Emp creation is not successful");
				
				//write into results
				sh.getRow(i).createCell(4).setCellValue("Emp creation is unscuccess");
			}
			
		}
		 fi.close();
		 fo=new FileOutputStream(new File(outpath));
		 wb.write(fo);
		 fo.close();
		 wb.close();
		Thread.sleep(5000);
		driver.quit();

	}

}
