package Main_Testcase;

import org.testng.annotations.Test;

import POM_model.AdminLoginPage;
import POM_model.Adminlogout;
import POM_model.BranchUpdatePage;
import POM_model.branchCreationPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TestScript {
	public static WebDriver driver;
	
  
  @BeforeMethod
  public void AdminLogin() throws InterruptedException {
	  driver=new ChromeDriver();
	  driver.navigate().to("http://primusbank.qedgetech.com");
	  driver.manage().window().maximize();
	  AdminLoginPage login=PageFactory.initElements(driver, AdminLoginPage.class);
	  //call login method
	  login.Verify_Login("Admin","Admin");
	  
	  
  }
  @Test(description="Verify Branch Creation",priority=0,enabled=true)
  public void BranchCreation() throws InterruptedException {
	  branchCreationPage branch=PageFactory.initElements(driver, branchCreationPage.class);
	  branch.Verify_creation("Royapettah", "Habibullah Road", "600017", "INDIA", "Tamil Nadu","CHENNAI");
	  Thread.sleep(4000);
	  String alertmessage=driver.switchTo().alert().getText();
	  Reporter.log(alertmessage,true);
	  Thread.sleep(4000);
	  driver.switchTo().alert().accept();
	  if(alertmessage.contains("New Branch with"))
	  {
		  Reporter.log("branch created success",true);
		  
	  }else{
		  Reporter.log("branch created unsuccess",true);
		  
	  }
  }

  @Test(description="Verify branch updation",priority=0,enabled=true)
  public void BranchUpdation() throws InterruptedException{
	  BranchUpdatePage updateb=PageFactory.initElements(driver,	BranchUpdatePage.class);
	  updateb.Verify_Branchupdate("Madipakkam", "Ram Nagar", "600083");
	  Thread.sleep(5000);
	  String alertmessage=driver.switchTo().alert().getText();
	  Reporter.log(alertmessage,true);
	  Thread.sleep(4000);
	  driver.switchTo().alert().accept();
	  if(alertmessage.contains("branch updated"))
	  {
		  Reporter.log("branch update success",true);
	  }else{
		  Reporter.log("branch update unsuccess",true);
		  
		 
	  }
  }
  @AfterMethod
  public void Logout() throws InterruptedException {
	  Adminlogout logout=PageFactory.initElements(driver, Adminlogout.class);
	  logout.Verify_logout();
	  driver.quit();
  }

}
