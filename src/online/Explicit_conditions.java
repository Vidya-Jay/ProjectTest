package online;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_conditions {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//create instance object for webdriver wait class
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement draglink=driver.findElement(By.xpath("//*[text()='Draggable']"));
		
		//wait until link is clickable
		wait.until(ExpectedConditions.elementToBeClickable(draglink));
		draglink.click();
	}

}
