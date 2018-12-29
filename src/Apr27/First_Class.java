package Apr27;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First_Class {
	 @BeforeMethod 
	  public void launch() {
		 Reporter.log("Running launch",true);
	  }
	  
	  @Test(priority=0,enabled=true)
	  public void login() {
	  Reporter.log("Running login",true);
	  }
	  
	  @Test(priority=2,enabled=true)
	  public void compose() {
		  Reporter.log("Running compose",true);
	  }
	  
	  @Test(priority=1,enabled=true)
	  public void reply() {
		  Reporter.log("Running reply",true);
	  }

	  @AfterMethod(alwaysRun=true)
	  public void logout() {
		  Reporter.log("Running logout",true);
	  }

	}


