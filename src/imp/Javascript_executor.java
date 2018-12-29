package imp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Javascript_executor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions ac=new Actions(driver);
		//launch url
		js.executeScript("window.location='https://flipkart.com'");
		ac.sendKeys(Keys.ESCAPE).perform();
		//print title of page
		String pagetitle=js.executeScript("return document.title").toString();
		System.out.println("pagetitle is ::"+pagetitle);
		//print url
		String url=js.executeScript("return document.URL;").toString();
		System.out.println("url is ::"+url);
		//print domain name
		String domain= js.executeScript("return document.domain;").toString();
		System.out.println("Domain="+domain);
		//refresh page
		js.executeScript("history.go(0)");
		//ac.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		//scroll page to 700 pixels
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(4000);
		//scroll top to bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//To scroll up completely
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(3000);
		driver.quit();
		

	}

}
