package Window_handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Using_iterator {
	public static WebDriver driver;
	@Test
	public void Windows_naukri() throws InterruptedException{
		driver = new ChromeDriver();
		driver.navigate().to("http://naukri.com/");
		driver.manage().window().maximize();
		//it will return the parent window name as string
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		//this will return the number of windows opened by web driver and will return set of strings
		Set<String> s1= driver.getWindowHandles();
		System.out.println(s1);
		//now we will iterate using iterator
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
		{
			String childwindow=i1.next();
			//here we will compare if parent window is not equal to child window then we will close
			if(!parent.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				System.out.println(driver.switchTo().window(childwindow).getTitle());
				Thread.sleep(5000);
				driver.close();
			}
		}
		
		//once all popup is closed now switch to parent window
		driver.switchTo().window(parent);
		//click on Register 
		driver.findElement(By.xpath("//*[@id='p0widget']/div/div[1]/div/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='flowBifurcation']/div[2]/form/div[1]/div/button")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
