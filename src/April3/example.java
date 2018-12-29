package April3;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Reporter;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	public class example {
	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream fi;
	@Parameters({"username","password"})
	@Test
	public void login(String user,String pass) throws IOException
	{
	     p=new Properties();
		fi=new FileInputStream("Repository.properties");
		p.load(fi);
		driver=new ChromeDriver();
		driver.navigate().to(p.getProperty("Objurl"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath(p.getProperty("Objusername"))).sendKeys(user);	
		driver.findElement(By.xpath(p.getProperty("Objpassword"))).sendKeys(pass);
		driver.findElement(By.xpath(p.getProperty("Objsign"))).click();
		String Expval=driver.getTitle();
		if(Expval.contains("Find"))
		{
			Reporter.log("Login success",true);
		}
		else{
			Reporter.log("Login unsuccess",true);
		}
		}	
	}




