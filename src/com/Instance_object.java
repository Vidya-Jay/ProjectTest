package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Instance_object {
	public static WebDriver dr;
	public void launch() {
		dr=new HtmlUnitDriver();
		dr.get("https://www.facebook.com/");

		String pagetitle=dr.getTitle();
		System.out.println("title is::"+pagetitle);
		System.out.println("title is::"+pagetitle.length());
		
	}
	public void Current_url() throws InterruptedException{
		String url=dr.getCurrentUrl();
		System.out.println("Current URL is::"+url);
		System.out.println("Current URL is::"+url.length());
		
		Thread.sleep(5000);
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		Instance_object obj=new Instance_object();
				obj.launch();
				obj.Current_url();
				

	}

}
