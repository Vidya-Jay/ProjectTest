package online;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Condition_Methods {
	public static WebDriver driver;
	public void Login() throws InterruptedException{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://www.rediff.com/");
		driver.manage().window().maximize();
		
		//click on sign in link
		driver.findElement(By.partialLinkText("Sig")).click();
		Thread.sleep(4000);
		
		//store username textbox into webelement
		WebElement username_textbox=driver.findElement(By.xpath(".//*[@id='login1']"));
		boolean user_enabled=username_textbox.isEnabled();
		System.out.println("user is enabled::"+ user_enabled);
		username_textbox.sendKeys("test@gmail.com");
		
		//check password textbox is enabled or not
		WebElement password_textbox= driver.findElement(By.xpath(".//*[@id='password']"));
		boolean password_enabled=password_textbox.isEnabled();
		System.out.println("password textbox is enabled::"+password_enabled);
		password_textbox.sendKeys("test1234");
		//store checkbox
		WebElement checkbox=driver.findElement(By.xpath(".//*[@id='remember']"));
		//uncheck checkbox from selection
		if (checkbox.isSelected())
			checkbox.click();
		Thread.sleep(5000);
		
		//store go button into webelement
		WebElement gobutton = driver.findElement(By.name("proceed"));
		boolean go_displayed=gobutton.isDisplayed();
		gobutton.click();
		Thread.sleep(5000);
		
		//get error message
		String message=driver.findElement(By.xpath(".//*[@id='login']/div[2]/div[2]")).getText();
		System.out.println(message);
		
		Thread.sleep(5000);
		driver.quit();
			
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		Condition_Methods obj=new Condition_Methods();
		obj.Login();

	}

}
