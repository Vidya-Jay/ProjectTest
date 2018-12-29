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

public class Table_example1 {
	public static WebDriver driver;
	@BeforeTest
	public void launch(){
		driver=new ChromeDriver();
		driver.navigate().to("file:///C:/Users/Vidya/Documents/Education/qedgetable.html");
		driver.manage().window().maximize();
	}
	@Test
	public void table(){
		String text=driver.findElement(By.xpath("//tr[4]/td[3]")).getText();
		System.out.println("specific row and column value is::"+text);
		
	//store  table into webelement class object
		
		WebElement table=driver.findElement(By.tagName("table"));
		
		//get collection of rows in the table
		
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		Reporter.log("no of rows are ::"+rows.size(),true);
		
		//iterate all rows
		
		for(int i=1;i<rows.size();i++){
			//get collection of columns
			List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
			if(i==1)
			{
				Reporter.log("no of columns are::"+cols.size(),true);
			}
		//iterate columns
			for(int j=0;j<cols.size();j++)
			{
				//get text of every column
				String eachcell=cols.get(j).getText();
				System.out.println("\t"+eachcell);
				Reporter.log(eachcell);
						
			}
			System.out.println();
	
		}
	}
		
		@AfterTest
		public void logout(){
			driver.quit();
		}
	
}