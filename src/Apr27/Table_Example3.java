package Apr27;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Table_Example3 {
public static WebDriver driver;
@BeforeTest
public void launch(){
	driver=new ChromeDriver();
	driver.navigate().to("http://content.icicidirect.com/idirectcontent/Home/Home.aspx");
	driver.manage().window().maximize();
}
@Test
public void Table() throws InterruptedException{
	Actions ac=new Actions(driver);
	WebDriverWait wait= new WebDriverWait(driver, 30);
	
	//click on markets link
	WebElement markets=driver.findElement(By.xpath("//*[@id='liMarket']/a"));
	wait.until(ExpectedConditions.elementToBeClickable(markets));
	ac.moveToElement(markets).click().perform();
	
	//click on marketstats link
	WebElement marketstats=driver.findElement(By.xpath("//*[@id='LiMarketStats']/a"));
	wait.until(ExpectedConditions.elementToBeClickable(marketstats));
	ac.moveToElement(marketstats).click().perform();
	Thread.sleep(5000);
	
	//click on dailyshare pricelink
	WebElement dsp=driver.findElement(By.partialLinkText("Daily"));
	wait.until(ExpectedConditions.elementToBeClickable(dsp));
	ac.moveToElement(dsp).click().perform();
	Thread.sleep(3000);
	
	//store complete table
	WebElement table=driver.findElement(By.id("gridSource"));
	
	//get no of rows from table
	
	List<WebElement>rows=table.findElements(By.tagName("tr"));
	System.out.println("no of rows are::"+rows.size());
	
	//iterate all rows
	for(WebElement eachrow:rows)
	{
		//get no of columns from rows
		
		List<WebElement>cols=eachrow.findElements(By.tagName("td"));
		
		//iterate all columns
		for(WebElement eachcell:cols){
			if (eachcell.getText().isEmpty())
				//click on next
			driver.findElement(By.xpath("//*[@id='gridSource']/tfoot/tr/th[3]")).click();
			System.out.print("\n"+eachcell.getText());
			
		}
		System.out.println("\n"+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("");
	}

}

@AfterTest
public void Logout(){
	driver.quit();
	
}



}

