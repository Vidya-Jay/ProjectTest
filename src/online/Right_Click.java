package online;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Right_Click {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		Actions ac=new Actions(driver);
		//right click on draggable link
		ac.moveToElement(driver.findElement(By.partialLinkText("Dra"))).contextClick().perform();
		

	}

}
