package Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class PrimusBankConstant {
public static Properties p;
public static FileInputStream fi;
public static WebDriver driver=new ChromeDriver();
@BeforeSuite
public static void launchApp() throws IOException{
	p=new Properties();
	fi=new FileInputStream("primusbankRepository.properties");
	p.load(fi);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(p.getProperty("objurl"));
	 
}
@AfterSuite
public static void closeApp(){
	driver.close();
}

}
