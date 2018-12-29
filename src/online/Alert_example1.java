package online;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alert_example1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Chaandrasekar");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]")).sendKeys("Venkatesan");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("chandrutec18@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("chandrutec18@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("  ");
        Select drop=new Select(driver.findElement(By.xpath("//*[@name='birthday_month']")));
        drop.selectByIndex(8);
        Select drop2=new Select(driver.findElement(By.xpath("//*[@name='birthday_day']")));
        drop2.selectByValue("20");
        Select drop3=new Select(driver.findElement(By.xpath("//*[@name='birthday_year']")));
        drop3.selectByValue("1987");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='_58mt' and @for='u_0_8']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Sign Up'")).click();
        Thread.sleep(5000);
        driver.quit();
	}

}
