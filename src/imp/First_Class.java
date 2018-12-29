package imp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class First_Class {
  
  @BeforeMethod
  public void launch() {
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
  public void afterMethod() {
	  
  }

}
