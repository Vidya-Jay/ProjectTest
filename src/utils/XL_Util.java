package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pack1.Reusable;

public class XL_Util {
	XLUtils excel=new XLUtils();
	Reusable re=new Reusable();
	@BeforeTest
	public void login(){
		re.Helper_Chrome("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		re.driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		re.driver.findElement(By.name("txtPassword")).sendKeys("Admin");
		re.driver.findElement(By.name("Submit")).click();
			
	}
	@Test
	public void Verify_EmpCreation() throws IOException, InterruptedException{
		String excelpath="C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\empcreation.xlsx";
		//count no of rows in a table
		int rc=excel.getRowCount(excelpath, "Login");
		//count no of columns in a row
		int cc=excel.getCellCount(excelpath, "Login", 0);
		Reporter.log("no of rows::"+rc+"  "+"no of columns::"+cc,true);
		for (int i=1;i<=rc;i++){
			re.driver.findElement(By.id("menu_pim_viewPimModule")).click();
			Thread.sleep(5000);
			re.driver.findElement(By.id("btnAdd")).click();
			Thread.sleep(5000);
			String fname=excel.getCellData(excelpath, "Login", i, 0);
			String mname=excel.getCellData(excelpath, "Login", i, 1);
			String lname=excel.getCellData(excelpath, "Login", i, 2);
			String eid=excel.getCellData(excelpath, "Login", i, 3);
			re.driver.findElement(By.name("firstName")).sendKeys(fname);
			re.driver.findElement(By.name("middleName")).sendKeys(mname);
			re.driver.findElement(By.name("lastName")).sendKeys(lname);
			re.driver.findElement(By.name("employeeId")).clear();
			re.driver.findElement(By.name("employeeId")).sendKeys(eid);
			re.driver.findElement(By.id("btnSave")).click();
			Thread.sleep(5000);
			String currenturl=re.driver.getCurrentUrl();
			if(currenturl.contains("empNumber"))
			{
				re.screenshotWithDate("\\orange\\", "\\empcreation");
				excel.setCellData(excelpath, "Login", i, 4, "Passed");
				excel.fillGreenColor(excelpath, "Login", i, 4);
				
			}else{
				re.screenshotWithDate("\\orange\\", "\\empcreation");
				excel.setCellData(excelpath, "Login", i, 4, "Passed");
				excel.fillRedColor(excelpath, "Login", i, 4);
			}
			
			
		}
		
	}
	@AfterTest
	public void logout(){
		re.driver.quit();
	}

}

