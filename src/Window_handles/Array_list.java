package Window_handles;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Array_list {
public static WebDriver driver;
@Test
public void VerifyMulitple_Windows() throws InterruptedException
{
	driver=new ChromeDriver();
	driver.navigate().to("http://naukri.com");
	driver.manage().window().maximize();
	//get parent window id
	String parent= driver.getWindowHandle();
	System.out.println(parent);
	ArrayList<String>window= new ArrayList<String>(driver.getWindowHandles());
	System.out.println(driver.switchTo().window(window.get(1)).getTitle());
	Thread.sleep(5000);
	driver.close();
	System.out.println(driver.switchTo().window(window.get(2)).getTitle());
	Thread.sleep(5000);
	driver.close();
	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//*[@value='Register with us']")).click();;
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@value='fresher']")).click();;
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@name='fname']")).sendKeys("vidya");
	Thread.sleep(4000);
	driver.close();
	
	
}
}
