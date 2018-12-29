package online;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webelement_Methods {
	public static WebDriver driver;
	public void verify_Login() throws InterruptedException{
		//create instance object
		driver=new FirefoxDriver();
		//launch url
		driver.get("http://opensource.demo.orangehrmlive.com/");
		//introduction of implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		//fill login form
		//store username textbox
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.clear();
		Thread.sleep(3000);
		username.sendKeys("Admin");
		
		//store password textbox
		
		WebElement Password=driver.findElement(By.xpath(".//*[@id='txtPassword']"));
		Password.clear();
		Thread.sleep(3000);
		Password.sendKeys("Admin");
		driver.findElement(By.cssSelector("#btnLogin")).click();
		
		String Acval=driver.getCurrentUrl();
		if(Acval.contains("dashboard"))
		{
			System.out.println("Login is successful");
		}
		else{
			System.out.println("Login is not successful");
		String message=driver.findElement(By.xpath(".//*[@id='spanMessage']")).getText();
		System.out.println(message);
		
	
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		Webelement_Methods d=new Webelement_Methods();
		d.verify_Login();
		
	}

}
