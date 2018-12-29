package POM_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Adminlogout {
	@FindBy(xpath="//tr/td[3]/a/img")
	WebElement logout;
	
public void Verify_logout() throws InterruptedException{
	logout.click();
	Thread.sleep(4000);
}
}
