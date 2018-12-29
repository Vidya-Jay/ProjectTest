package April3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webtour_OR {
	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream fi;
	
	@BeforeMethod
	public void Launch() throws IOException{
		driver=new ChromeDriver();
		p=new Properties();
		fi=new FileInputStream("Repositories.properties");
		p.load(fi);
		driver.navigate().to(p.getProperty("Objurl"));
		driver.manage().window().maximize();
	}
	
@Test(description="Verify Login",priority=0,enabled=true)
public void verify_Login()
{
	driver.findElement(By.xpath(p.getProperty("Objusername"))).sendKeys("admin");
	driver.findElement(By.xpath(p.getProperty("Objpassword"))).sendKeys("mercury");
	driver.findElement(By.xpath(p.getProperty("Objsignin"))).sendKeys(Keys.ENTER);
	String Expval=driver.getTitle();
	if(Expval.contains("Find"))
	{
		Reporter.log("Login success",true);
	}
	else{
		Reporter.log("Login not success",true);
	}
	
}
@Test(description="Verify_register",priority=1,enabled=true)
public void Verify_Register() throws InterruptedException{
	driver.findElement(By.xpath(p.getProperty("ObjRegister"))).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath(p.getProperty("Objfname"))).sendKeys("Sita123");
	driver.findElement(By.xpath(p.getProperty("Objlname"))).sendKeys("meta12");
	driver.findElement(By.xpath(p.getProperty("Objphone"))).sendKeys("12345");
	driver.findElement(By.xpath(p.getProperty("Objemail"))).sendKeys("Sita123@gmail.com");
	driver.findElement(By.xpath(p.getProperty("Objaddress"))).sendKeys("hyderabad");
	driver.findElement(By.xpath(p.getProperty("Objcity"))).sendKeys("srnagar");
	driver.findElement(By.xpath(p.getProperty("Objstate"))).sendKeys("TS");
	driver.findElement(By.xpath(p.getProperty("Objpcode"))).sendKeys("12345");
	new Select(driver.findElement(By.xpath(p.getProperty("Objcountry")))).selectByIndex(10);
	Thread.sleep(5000);
	driver.findElement(By.xpath(p.getProperty("Objuname"))).sendKeys("Sita123");
	WebElement pwd=driver.findElement(By.xpath(p.getProperty("Objpass")));
	pwd.sendKeys("Sita123");
	String password=pwd.getAttribute("value");

	WebElement cpassword=driver.findElement(By.xpath(p.getProperty("Objcpass")));
	cpassword.sendKeys("Sita123");
	String cpwd=cpassword.getAttribute("value");
	driver.findElement(By.xpath(p.getProperty("Objsubmit"))).click();
	if (password.equals(cpwd))
	{
		String message=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText();
		Reporter.log(message,true);
		Reporter.log("Register success",true);
	}
	else{
		Reporter.log("Register not success",true);
	}
	
	
	
}


@AfterMethod
public void Logout() throws InterruptedException{
	Thread.sleep(5000);
	driver.quit();
}
}