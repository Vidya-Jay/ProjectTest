package imp;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Second_Class {
	@BeforeTest
	public void launch(){
		Reporter.log("running launch",true);
	}
	
	@Test(description="Verify login",priority=0,enabled=true)
	public void login(){
		Reporter.log("running login",true);
		
	}
	@Test(description="Verify Compose",priority=2,enabled=false)
	public void compose(){
		Reporter.log("running compose",true);
		
	}
	@Test(description="Verify Reply",priority=1,enabled=true)
	public void reply(){
		Reporter.log("running reply",true);
		
	}

	@AfterTest(alwaysRun=true)
	public void logout(){
		Reporter.log("running logout",true);
}
}