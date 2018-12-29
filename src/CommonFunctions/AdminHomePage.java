package CommonFunctions;

import org.openqa.selenium.By;

import Constants.PrimusBankConstant;

public class AdminHomePage extends PrimusBankConstant {
	public boolean adminLogout(){
		driver.findElement(By.xpath(p.getProperty("objlogout"))).click();
		if(driver.findElement(By.id("login")).isDisplayed())
		{
			return true;
		}else{
			return false;
		}
	}
public void navigateToBranchDetailsPage() throws InterruptedException{
	driver.findElement(By.xpath(p.getProperty("objbranches"))).click();
	Thread.sleep(4000);
	
}
		
	}
	

	


