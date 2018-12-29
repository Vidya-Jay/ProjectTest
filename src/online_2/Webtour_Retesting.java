package online_2;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webtour_Retesting {
	public static WebDriver driver;
	public static File f;
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow r;
	public static FileOutputStream fo;
	
	@BeforeTest
	public void Launch_browser(){
		driver=new ChromeDriver();
	}
	
	@Test
	public void Register() throws InterruptedException, IOException
	{
		//get excel path
		String path="C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\webreg.xlsx";
		f=new File(path);
		//read data from file
		fi= new FileInputStream(f);
		//create workbook object
		wb=new XSSFWorkbook(fi);
		//get sheet from workbook
		ws=wb.getSheetAt(0);
		//count no of rows in a sheet
		int rc=ws.getLastRowNum();
		//get first row from sheet
		r=ws.getRow(0);
		//get the count of columns in the first row
		int cc=r.getLastCellNum();
		Reporter.log("no of rows ::"+rc+"  "+"no of columns are::"+cc,true);
		//iterate all rows
		for (int i=1;i<=rc;i++)
		{
			//launch url
			driver.navigate().to("http://newtours.demoaut.com");
			driver.manage().window().maximize();
			//click on register link
			driver.findElement(By.partialLinkText("REG")).click();
			Thread.sleep(5000);
			//fill the form and access data from excel
			driver.findElement(By.name("firstName")).sendKeys(ws.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.name("lastName")).sendKeys(ws.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.name("phone")).sendKeys(ws.getRow(i).getCell(2).getStringCellValue());
			driver.findElement(By.name("userName")).sendKeys(ws.getRow(i).getCell(3).getStringCellValue());
			driver.findElement(By.name("address1")).sendKeys(ws.getRow(i).getCell(4).getStringCellValue());
			driver.findElement(By.name("city")).sendKeys(ws.getRow(i).getCell(6).getStringCellValue());
			driver.findElement(By.name("state")).sendKeys(ws.getRow(i).getCell(7).getStringCellValue());
			driver.findElement(By.name("postalCode")).sendKeys(ws.getRow(i).getCell(8).getStringCellValue());
			driver.findElement(By.name("country")).sendKeys(ws.getRow(i).getCell(9).getStringCellValue());
			driver.findElement(By.name("email")).sendKeys(ws.getRow(i).getCell(10).getStringCellValue());
			driver.findElement(By.name("password")).sendKeys(ws.getRow(i).getCell(11).getStringCellValue());
		    driver.findElement(By.name("confirmPassword")).sendKeys(ws.getRow(i).getCell(12).getStringCellValue());
			driver.findElement(By.name("register")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			//compare password and confirm password
			if(ws.getRow(i).getCell(11).getStringCellValue().equals(ws.getRow(i).getCell(12).getStringCellValue()))
			{
				Reporter.log("Register Success",true);
				//write as register success into results column
				ws.getRow(i).createCell(13).setCellValue("password and confirm password are same");
				String message= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[2]")).getText();
				//write message into status column
				ws.getRow(i).createCell(14).setCellValue(message);
			}
			else{
				Reporter.log("Register Unsuccess",true);
				ws.getRow(i).createCell(13).setCellValue("password and confirm password are not same");
				ws.getRow(i).createCell(14).setCellValue("failed");
				
			}
							
		}
		
		//close readable file
		fi.close();
		fo=new FileOutputStream(f);
		wb.write(fo);
		fo.close();
		wb.close();
		
		
		
	}

	@AfterTest
	public void logout(){
		driver.quit();
	}
}
