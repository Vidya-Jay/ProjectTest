package online;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mouse_hover1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		System.out.println("pagetitle[1]::"+driver.getTitle());
		
		//create object for actions class
		Actions ac=new Actions(driver);
		//to close login window
		ac.sendKeys(Keys.ESCAPE).perform();
		//mouse hover to electronic link
		ac.moveToElement(driver.findElement(By.xpath(".//*[text()='Electronics']"))).click().perform();
		System.out.println("Pagetitle[2]::"+driver.getTitle());
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement applelink=driver.findElement(By.xpath("//*[text()='Apple']"));
		//Wait until apple link is visible
		wait.until(ExpectedConditions.visibilityOf(applelink));
		ac.moveToElement(applelink).click().perform();
		System.out.println("Pagetitle[3]::"+driver.getTitle());
		Thread.sleep(50);
		
	}

}
