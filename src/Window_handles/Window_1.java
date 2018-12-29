package Window_handles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Window_1 {
	public static WebDriver driver;
	@Test
	public void Verify_windowhandle() throws InterruptedException{
		driver=new ChromeDriver();
		driver.navigate().to("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/");
		driver.manage().window().maximize();
		//get parent window id
		String parent= driver.getWindowHandle();
		System.out.println(parent);
		//click on orangehrm link
		driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']")).click();
		Thread.sleep(5000);
		//get all window ids
		Set<String> allwindows=driver.getWindowHandles();
		System.out.println(allwindows);
		//iterate all windows
		for(String eachwin:allwindows)
		{
			//compare parent window should not be equal to child window
			if(!parent.equals(eachwin))
			{
				//switch to child window
				driver.switchTo().window(eachwin);
				//click on request a quote link
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[3]/div/article/div[1]/a[1]")).click();
				Thread.sleep(5000);
				//fill the form
				new Select(driver.findElement(By.name("Package"))).selectByIndex(1);
				driver.findElement(By.name("FirstName")).sendKeys("test12345");
				driver.findElement(By.name("LastName")).sendKeys("mita123");
				driver.findElement(By.name("CompanyName")).sendKeys("qedge tech");
				new Select(driver.findElement(By.name("Industry"))).selectByIndex(10);
				Thread.sleep(5000);
				
				
				//switch to parent window
				driver.switchTo().window(parent);
				Thread.sleep(5000);
				driver.findElement(By.name("txtUsername")).sendKeys("Admin");
				driver.findElement(By.name("txtPassword")).sendKeys("Admin");
				driver.findElement(By.name("Submit")).click();
				Thread.sleep(5000);
				driver.quit();
							
				
				
			}
		}
	}

}
