package com;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_Validation {
public static WebDriver dr;

public void launch(){
	//create Instance Object
	dr=new ChromeDriver();
	//launch url
	dr.get("https://www.facebook.com/");
	//maximize browser
	dr.manage().window().maximize();
	
}

//verify primus bank title is matching
public void Testcase1_verifytitle(){
	//get title and store
	String pagetitle=dr.getTitle();
	if (pagetitle.equalsIgnoreCase("primus bank"))
	{
		System.out.println("title is matching::"+pagetitle);
	}
	else{
		System.out.println("title is not matching::"+pagetitle);
		
	}
	
}
//verify url contains protocol https://
public void Testcase2_Verify_Protocol(){
	String url=dr.getCurrentUrl();
	if(url.contains("https://"))
	{
		System.out.println("url contains protocol::"+url);
	}
	else{
		System.out.println("url does not contains protocol::"+url);
	}
}
	//verify whether pagesource contains title primus bank
public void Testcase3_Verify_pagesource() throws InterruptedException{
	String pagesource=dr.getPageSource();
	if(pagesource.contains("primus bank"))
	{
		System.out.println("pagesource contains title");
	}
	else{
		System.out.println("pagesource does not contains title");
	}
Thread.sleep(5000);
}

	
	public static void main(String[] args) throws InterruptedException {
		Get_Validation g=new Get_Validation();
		g.launch();
		g.Testcase1_verifytitle();
		g.Testcase2_Verify_Protocol();
		g.Testcase3_Verify_pagesource();

	}

}
