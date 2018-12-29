package online;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop_down {
public static WebDriver driver;
public void Drop_down_verify() throws InterruptedException{
	driver = new ChromeDriver();
	driver.navigate().to("https://harvesthq.github.io/chosen/");
	driver.manage().window().maximize();
	
	//Store drop down into Select class object
	Select drop=new Select(driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/select/option[1]")));
	
	boolean value=drop.isMultiple();
	System.out.println(value);
	drop.selectByVisibleText("United States");
	Thread.sleep(4000);
	drop.selectByIndex(2);
	Thread.sleep(3000);
	drop.selectByIndex(5);
	Thread.sleep(3000);
	drop.selectByIndex(7);
	Thread.sleep(3000);
	System.out.println(drop.getFirstSelectedOption().getText());
	
	//count only item which got selected
	
	List<WebElement> count=drop.getAllSelectedOptions();
	
	System.out.println(("no of items selected::"+count.size()));
	
	//iterate all selected items
	
	
}
	public static void main(String[] args) throws InterruptedException {
	Drop_down n=new Drop_down();
	n.Drop_down_verify();

	}

}
