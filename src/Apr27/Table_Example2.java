package Apr27;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Table_Example2 {
public static WebDriver driver;
@BeforeTest
public void launch(){
	driver= new ChromeDriver();
	driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
	driver.manage().window().maximize();
}
@Test
public void Table(){
	WebElement table=driver.findElement(By.id("customers"));
	List<WebElement> rows=table.findElements(By.tagName("tr"));
	Reporter.log("no of rows are::"+rows.size(),true);
	String reqcellvalue="UK";
	for(WebElement eachcol:rows)
	{
		List<WebElement> cols=eachcol.findElements(By.tagName("td"));
		for(WebElement eachcell:cols)
		{
			String text=eachcell.getText();
			System.out.print("\n"+text);
		
		if (reqcellvalue.equals(text)){
			System.out.println("found at"+(rows.size()-2)+"th row"+(cols.size())+"th column");
			
		}
	}
	System.out.println();
}
}
@AfterTest
public void logout(){
	driver.quit();
}
}