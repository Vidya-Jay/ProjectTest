package online;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert_handling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("file:///C:/Users/Vidya/Documents/Education/promp.html");
		driver.manage().window().maximize();
		//click on me button
		driver.findElement(By.xpath("html/body/fieldset/button")).click();
		//Get alert message
	    String alerttext=driver.switchTo().alert().getText();
	    System.out.println(alerttext);
	    driver.switchTo().alert().sendKeys("Vidya");
	    //accept popup
	    driver.switchTo().alert().accept();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='promptdemo']"));
	    Thread.sleep(5000);
	    driver.quit();

	}

}
