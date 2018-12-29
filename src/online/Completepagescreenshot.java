package online;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.DriverSessions;


public class Completepagescreenshot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");
		driver.manage().window().maximize();
		//take screenshot and store into one variable
		//Java timestamp
		DateFormat df=new SimpleDateFormat("dd_MM_yyy  hh_mm_ss");
		Date d=new Date();
		String datef=df.format(d);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy screenshot into local system
		
	   try {
		FileUtils.copyFile(src, new File("C://Users//Vidya//Selenium/"+datef+"homepage.jpg"));
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
	   Thread.sleep(4000);
	   driver.quit();
	   
	   
		
		
		

	}

}
