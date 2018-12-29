package imp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascript_Executor2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location='http://facebook.com'");
		js.executeScript("document.getElementById('email').value='vidya.shalom87@gmail.com'");
		js.executeScript("document.getElementById('email').style.backgroundColor='green'");
		Thread.sleep(5000);
		js.executeScript("document.getElementById('email').style.color='red';");
		Thread.sleep(3000);
		js.executeScript("document.getElementById('pass').value='test12345'");
		 js.executeScript("document.querySelector('#u_0_2').click()");
		js.executeScript("alert('Vidya Chandrasekar')");
		Thread.sleep(5000);
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);
		driver.quit();
	}

}
