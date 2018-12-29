package Main_Testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM_model.AdminLoginPage;
import POM_model.Adminlogout;
import POM_model.branchCreationPage;
import utils.XLUtils;

public class Driverscript {
	XLUtils excel=new XLUtils();
	String excelpath="C:\\Users\\Vidya\\Framework-Online\\Primus_banking\\Test Data\\Branch_Creation.xlsx";
	public static WebDriver driver;
	@BeforeTest
	public void Admin_Login() throws InterruptedException{
		driver=new ChromeDriver();
		driver.navigate().to("http://primusbank.qedgetech.com");
		driver.manage().window().maximize();
		AdminLoginPage login=PageFactory.initElements(driver, AdminLoginPage.class);
		login.Verify_Login("Admin", "Admin");
	}
@Test
public void BranchCreation() throws IOException, InterruptedException{
	int rc= excel.getRowCount(excelpath, "Branches");
	int cc=excel.getCellCount(excelpath, "Branches", 0);
	Reporter.log("no of rows::"+rc+" "+"no of columns"+cc,true);
	
	for(int i=1;i<=rc;i++)
	{
		String bname=excel.getCellData(excelpath, "Branches", i, 0);
		String add1=excel.getCellData(excelpath, "Branches", i, 1);
		String zipcode=excel.getCellData(excelpath, "Branches", i, 2);
		String country=excel.getCellData(excelpath, "Branches", i, 3);
		String state=excel.getCellData(excelpath, "branches", i, 4);
		String city=excel.getCellData(excelpath, "branches", i, 5);
		branchCreationPage branch=PageFactory.initElements(driver, branchCreationPage.class);
		branch.Verify_creation(bname, add1, zipcode, country, state, city);
		Thread.sleep(4000);
		String alertmessage=driver.switchTo().alert().getText();
		Reporter.log(alertmessage,true);
		driver.switchTo().alert().accept();
		if(alertmessage.contains("New Branch with")){
			Reporter.log("branch creation success",true);
			excel.setCellData(excelpath, "branches", i, 6, alertmessage);
		}else{
			Reporter.log("branch creation unsuccess",true);
		}
	}
}
@AfterTest
public void Logout() throws InterruptedException{
	Adminlogout logout=PageFactory.initElements(driver, Adminlogout.class);
	logout.Verify_logout();
	driver.quit();
}
}
