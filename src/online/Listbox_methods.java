package online;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Listbox_methods {
public static WebDriver obj;
public void VerifyListbox() throws InterruptedException{
	obj=new ChromeDriver();
	obj.navigate().to("https://www.facebook.com/");
	obj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//store month listbod into select class object
	
	Select omonth=new Select(obj.findElement(By.name("birthday_month")));
	
	//check whether selection multi selection
	boolean value =omonth.isMultiple();
	System.out.println(value);
	omonth.selectByVisibleText("Dec");
	Thread.sleep(4000);
	omonth.selectByIndex(10);
	Thread.sleep(5000);
	
	//count no of items in a listbox
	
	List<WebElement> countitems=omonth.getOptions();
	System.out.println("no of items are::"+countitems.size());
	
	//iterate all items
	String reqmonth="Jul";
	int counter=0;
	for(int i=1;i<countitems.size();i++)
	{
		//print names of each item into console
		String itemname=countitems.get(i).getText();
		System.out.println(itemname);
		if (reqmonth.equalsIgnoreCase(itemname)){
	     omonth.selectByIndex(i);
		 counter=1;
		 break;
		}
	}
	
	if(counter==0){
		System.out.println(reqmonth+"notfound");
	}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Listbox_methods n=new Listbox_methods();
		n.VerifyListbox();

	}

}
