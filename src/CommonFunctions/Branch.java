package CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constants.PrimusBankConstant;
import utils.Taking_Screenshot;

public class Branch extends PrimusBankConstant {
	public String brname;
	public String add1;
	public String add2;
	public String add3;
	public String area;
	public String zipcode;
	public String country;
	public String city;
	public String state;
	
public boolean createBranch(String branchname,String add1,String add2,String zipcode,String country,
		String city,String state) throws InterruptedException{
	driver.findElement(By.xpath(p.getProperty("objnewbranch"))).click();
	driver.findElement(By.xpath(p.getProperty("objbname"))).sendKeys(branchname);
	driver.findElement(By.xpath(p.getProperty("objadd1"))).sendKeys(add1);
	driver.findElement(By.xpath(p.getProperty("objadd2"))).sendKeys(add2);
	driver.findElement(By.xpath(p.getProperty("objzcode"))).sendKeys(zipcode);
	WebElement countryelement;
	countryelement = driver.findElement(By.xpath(p.getProperty("objcountry")));
	Select countrylist= new Select (countryelement);
	countrylist.selectByVisibleText(country);
	Thread.sleep(4000);
	WebElement stateelement;
	stateelement=driver.findElement(By.xpath(p.getProperty("objstate")));
	Select statelist= new Select(stateelement);
	statelist.selectByVisibleText(state);
	Thread.sleep(4000);
	WebElement cityelement;
	cityelement= driver.findElement(By.xpath(p.getProperty("objcity")));
	Select citylist= new Select(cityelement);
	citylist.selectByVisibleText(city);
	driver.findElement(By.xpath(p.getProperty("objsubmit"))).click();
	Taking_Screenshot.takescreenshot(driver, "branch");
	Thread.sleep(5000);
	String alertmsg= driver.switchTo().alert().getText();
	System.out.println(alertmsg);
	Thread.sleep(4000);
	driver.switchTo().alert().accept();
	if(alertmsg.toLowerCase().contains("new branch with"))
	{
		return true;
	}
	else
	{
		return false;
	}
}

}
