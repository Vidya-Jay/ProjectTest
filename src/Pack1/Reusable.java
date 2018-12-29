package Pack1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Reusable {
	public static WebDriver driver;
	public static DateFormat df;
	public static String dtformat;
	public static void  Helper_Chrome(String url){
		driver=new ChromeDriver();
		driver.navigate().to(url);
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
		
	}
	public static void  Helper_firefox(String url){
		driver=new FirefoxDriver();
		driver.navigate().to(url);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
		
	}
	public static void  Helper_iebrowser(String url){
		driver=new InternetExplorerDriver();
		driver.navigate().to(url);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
		
	}
	public static void screenshotWithDate(String foldername,String filename) throws IOException
	{
	 df=new SimpleDateFormat("MM_dd_yyyy hh_mm_ss");
	 dtformat=df.format(new Date());
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("c:/"+foldername+"/"+dtformat+filename+".png"));
	}
	}



