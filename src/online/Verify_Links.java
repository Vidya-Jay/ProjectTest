package online;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Verify_Links {

	public static void main(String[] args) throws InterruptedException {
		String baseurl="http://newtours.demoaut.com";
		WebDriver dr=new FirefoxDriver();
		String underconstitle= "Under Construction: Mercury Tours";
		
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.get(baseurl);
		dr.manage().window().maximize();
		List<WebElement> linkelements= dr.findElements(By.tagName("a"));
		System.out.println("no. of links are::"+linkelements.size());
		String[] linkTexts= new String[linkelements.size()];
		int i=0;
		
		//extract the link texts of each link elements
		for (WebElement e:linkelements) {
			linkTexts[i]=e.getText();
			 i++;
		}
		//test each link
		for (String t:linkTexts){
			dr.findElement(By.linkText(t)).click();
			Thread.sleep(3000);
			if (dr.getTitle().equals(underconstitle)){
				System.out.println("\""+t+"\""+"is under construction");
			}
			else{
				System.out.println("\""+t+"\""+"is working fine");
			}
		dr.navigate().back();
			
		}

	}

}
