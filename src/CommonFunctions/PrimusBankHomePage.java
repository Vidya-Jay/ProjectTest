package CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Constants.PrimusBankConstant;
import utils.Taking_Screenshot;

public class PrimusBankHomePage extends PrimusBankConstant {
	public String adminuid;
	public String adminpwd;
	public void login(String uid,String pwd){
		driver.findElement(By.xpath(p.getProperty("objusername"))).sendKeys(uid);
		driver.findElement(By.xpath(p.getProperty("objpassword"))).sendKeys(pwd);
		driver.findElement(By.xpath(p.getProperty("objloginbtn"))).sendKeys(Keys.ENTER);
		
		
	}
	public boolean 	adminlogin(String uid,String pwd) {
		String expurl,acurl;
		expurl="adminflow";
		login(uid,pwd);
		acurl=driver.getCurrentUrl();
		if(acurl.toLowerCase().contains(expurl.toLowerCase()))
		{
			Taking_Screenshot.takescreenshot(driver, "LoginPage");
			return true;
		}
		else
		{
			Taking_Screenshot.takescreenshot(driver, "LoginPage");
			return false;
		}
		
	}
}
	


