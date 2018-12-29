package online;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_drop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://jqueryui.com/droppable/");
		//create object for actions class
		Actions ac=new Actions(driver);
		
		//switch to frames
		driver.switchTo().frame(0);//index 0 means first frame
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dst=driver.findElement(By.id("droppable"));
		
		//first method to drag and drop
		//ac.clickAndHold(src).moveToElement(dst).release().perform();
		//second method
		ac.dragAndDrop(src, dst).perform();
		if (dst.getText().matches("Dropped!"))
			System.out.println("drag and drop is sucess");
		Thread.sleep(5000);
		driver.quit();

	}

}
