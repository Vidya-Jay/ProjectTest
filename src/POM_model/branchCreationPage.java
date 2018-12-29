package POM_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class branchCreationPage {
@FindBy(xpath="//table/tbody/tr[2]/td/a/img")
WebElement click_branch;
@FindBy(xpath="//*[@id='BtnNewBR']")
WebElement click_newbranch;
@FindBy(name="txtbName")
WebElement enter_bname;
@FindBy(name="txtAdd1")
WebElement enter_add1;
@FindBy(name="txtZip")
WebElement enter_zipcode;
@FindBy(name="lst_counrtyU")
WebElement select_country;
@FindBy(name="lst_stateI")
WebElement select_state;
@FindBy(name="lst_cityI")
WebElement select_city;
@FindBy(name="btn_insert")
WebElement click_submit;

public void Verify_creation(String bname,String add1,String zipcode,String country,String state,String city) throws InterruptedException{
	click_branch.click();
	Thread.sleep(4000);
	click_newbranch.click();
	Thread.sleep(4000);
	this.enter_bname.sendKeys(bname);
	Thread.sleep(4000);
	this.enter_add1.sendKeys(add1);
	Thread.sleep(4000);
	this.enter_zipcode.sendKeys(zipcode);
	Thread.sleep(4000);
	this.select_country.sendKeys(country);
	Thread.sleep(4000);
	this.select_city.sendKeys(city);
	Thread.sleep(4000);
	this.select_state.sendKeys(state);
	Thread.sleep(4000);
	click_submit.click();
	Thread.sleep(4000);
	
}
}
