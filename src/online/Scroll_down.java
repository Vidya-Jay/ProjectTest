package online;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scroll_down {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://flipkart.com/");
		driver.manage().window().maximize();

		Actions ac=new Actions(driver);
		ac.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(5000);
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		ac.sendKeys(Keys.PAGE_DOWN).perform();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement onlineshop= driver.findElement(By.xpath("//*[text()='Online Shopping']"));
		//wait until online shop link is visible
		wait.until(ExpectedConditions.visibilityOf(onlineshop));
		ac.moveToElement(onlineshop).click().perform();
		

	}

}
