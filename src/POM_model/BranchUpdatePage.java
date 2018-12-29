package POM_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchUpdatePage {
	@FindBy(xpath="//table/tbody/tr[2]/td/a/img")
	WebElement click_branch;
	@FindBy(xpath="//*[@id='DG_bankdetails']/tbody/tr[2]/td[7]/a/img")
	WebElement click_edit;
	@FindBy(name="txtbnameU")
	WebElement updatebname;
	@FindBy(name="txtadd1u")
	WebElement updateadd1;
	@FindBy(name="txtzipu")
	WebElement updatezipcode;
	@FindBy(name="btnupdate")
	WebElement click_update;
	public void Verify_Branchupdate(String updatebname,String updateadd1,String updatezipcode) throws InterruptedException{
		click_branch.click();
		Thread.sleep(4000);
		click_edit.click();
		Thread.sleep(4000);
		this.updatebname.clear();
		this.updatebname.sendKeys(updatebname);
		this.updateadd1.clear();
		this.updateadd1.sendKeys(updateadd1);
		this.updatezipcode.clear();
		this.updatezipcode.sendKeys(updatezipcode);
		click_update.click();
		Thread.sleep(4000);
	}
	

}
