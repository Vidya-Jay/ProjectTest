package online;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Right_click1 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://jqueryui.com/droppable/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Actions ac=new Actions(driver);
		//right clink on draggable link
		ac.moveToElement(driver.findElement(By.partialLinkText("Dra"))).contextClick().perform();
		Robot r=new Robot();
		//press down arrow
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.quit();
		
 
	}

}
