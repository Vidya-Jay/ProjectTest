package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Instance_object2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new HtmlUnitDriver();
		//open url in chrome window
		driver.get("https://www.google.ca/");
		//maximize window
	
		//print title of the page
		String pagetitle=driver.getTitle();
		System.out.println("title is ::"+pagetitle);
		System.out.println("title length is::"+pagetitle.length());
		//print current url
		String url=driver.getCurrentUrl();
		System.out.println("current url is ::"+url);
		System.out.println("current url is ::"+url.length());
		Thread.sleep(5000);
		
		
		
		
				

	}

}
