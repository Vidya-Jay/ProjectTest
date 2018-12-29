package online;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find_elements {
	public static WebDriver driver;
	public void Print_Links() throws InterruptedException{
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().to("https://www.yahoo.com//");
		driver.manage().window().maximize();
		//get all links which are under a tag and store
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("no of links are::"+links.size());
		
		//iterate all links
		
		for(WebElement eachlink:links) {
			//get all link text
			String linkname=eachlink.getText();
			//get url of all links
			String url=eachlink.getAttribute("href");
			
			System.out.println(linkname);
			System.out.println(url);
		}
		
		Thread.sleep(4000);
		driver.quit();
			
	}
	

	public static void main(String[] args) throws InterruptedException {
		Find_elements d = new Find_elements();
		d.Print_Links();

	}

}
