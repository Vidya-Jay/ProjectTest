package Dataprovide;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datasupply {
	WebDriver driver;
	@DataProvider
	public Object[][] Verify_Login(){
		Object[][] login=new Object[3][3];
		//first iteration
		login[0][0]="Akilesh";
		login[0][1]="test12345";
		login[0][2]="test1234";
		//second iteration
		login[1][0]="Akhil";
		login[1][1]="rita";
		login[1][2]="rita";
		
		//third iteration
		login[2][0]="Arun";
		login[2][1]="selenium";
		login[2][2]="selenium";
		return login;
	}


 @Test(dataProvider="Verify_Login")
	public void Login(String username,String password,String confirmpassword){
	 driver=new ChromeDriver();
	 driver.navigate().to("http://newtours.demoaut.com");
	 driver.manage().window().maximize();
	 driver.findElement(By.partialLinkText("REG")).click();
	 driver.findElement(By.name("email")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
	 driver.findElement(By.name("register")).sendKeys(Keys.ENTER);
	 if(password.equals(confirmpassword))
	 {
		 Reporter.log("Register success",true);
		 
		 String Message=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText();
		 Reporter.log(Message,true);
	 }else{
		 Reporter.log("Register unsuccess",true);
	 }
	 driver.quit();
	 }
 

}
