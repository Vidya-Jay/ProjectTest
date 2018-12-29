package POM_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	@FindBy(xpath="//*[@id='txtuId']")
	WebElement username;
	@FindBy(xpath="//*[@id='txtPword']")
	WebElement password;
	@FindBy(name="login")
	WebElement login;
	
public void Verify_Login(String username,String password) throws InterruptedException{
	this.username.sendKeys(username);
	this.password.sendKeys(password);
	login.click();
	Thread.sleep(5000);
}
}
