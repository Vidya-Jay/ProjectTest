package April3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameter_Login {
	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream fi;
	@Parameters({"username","password"})
	
@Test
public void login (String user,String pass) throws IOException{
p= new Properties();
fi=new FileInputStream("Repositories.properties");
p.load(fi);
driver.navigate().to(p.getProperty("Objurl"));
driver.manage().window().maximize();
driver.findElement(By.xpath(p.getProperty("Objusername"))).sendKeys(user);
driver.findElement(By.xpath(p.getProperty("Objpassword"))).sendKeys(pass);
driver.findElement(By.xpath(p.getProperty("Objsignin"))).click();
String Expval=driver.getTitle();
if(Expval.contains("Find"))
{
	Reporter.log("login sucess",true);
}
else{
	Reporter.log("login unsucess",true);
}
	}
}




