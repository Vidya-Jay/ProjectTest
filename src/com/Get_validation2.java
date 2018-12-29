package com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Get_validation2 {
public static WebDriver dr;
public void launch(){
	//create Instance object
	dr= new FirefoxDriver();
	//launch URl
	dr.get("http://primusbank.qedgetech.com/");
	//maximize browser
	dr.manage().window().maximize();
	
}
public void Testcase1_verifytitle(){
	//verify primus bank title is matching
	String pagetitle = dr.getTitle();
	if(pagetitle.equalsIgnoreCase("Primus bank"))
	{
		System.out.println("title is matching::"+pagetitle);
	}
	else{
		System.out.println("title is not matching::"+pagetitle);
	}
}

public void Testcase2_Verify_protocol(){
	//Verify URL contains protocol
	String url=dr.getCurrentUrl();
			if(url.contains("https://"))
			{
				System.out.println("URL contains protocol");
			}
			else{
				System.out.println("URL does not contain protocol");
			}
}

public void Testcase3_verifypagesource() throws InterruptedException{
	//verify whether pagesource contains title primus bank
	String pagesource= dr.getPageSource();
	if(pagesource.contains("primus bank"))
	{
		System.out.println("pagesource contains title");
	}
	else{
		System.out.println("pagesource does not contains title");
	}Thread.sleep(5000);
}
	public static void main(String[] args) throws InterruptedException {
		Get_validation2 g=new Get_validation2();
	    g.launch();
		g.Testcase1_verifytitle();
	
		g.Testcase2_Verify_protocol();
		g.Testcase3_verifypagesource();

	}

}
