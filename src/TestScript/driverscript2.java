package TestScript;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import CommonFunctions.AdminHomePage;
import CommonFunctions.Branch;
import CommonFunctions.PrimusBankHomePage;
import Constants.PrimusBankConstant;
import utils.XLUtils;

public class driverscript2 extends PrimusBankConstant{

	public static Logger log;	
	XLUtils xl=new XLUtils();
	String xlfile="E:\\Framework_Online\\Primus_Banking\\src\\config\\Controller.xlsx";
	String tcsheet="TestCases";
	String tssheet="TestSteps";
	PrimusBankHomePage phome=new PrimusBankHomePage();
	AdminHomePage ahome=new AdminHomePage();
	Branch branchc=new Branch();
	@Test
	public void keywordDrivenTest() throws InterruptedException, IOException
		{
	log=Logger.getLogger("driverscript2");
	PropertyConfigurator.configure("E:\\Framework_Online\\Primus_Banking\\src\\config\\Log4j.properties");	
	int tccount,tscount;
	String tcexeflg,tcid,tstcid,keyword;
	boolean res=false;
	String tcres="";
	tccount=xl.getRowCount(xlfile, tcsheet);
	log.info("counting no of rows in first sheet::"+tccount);
	tscount=xl.getRowCount(xlfile, tssheet);
	log.info("counting no of rows in second sheet::"+tscount);
	for (int i = 1; i <= tccount; i++) 
	{
	log.info("iterate first sheet rows");
	tcexeflg=xl.getCellData(xlfile, tcsheet, i, 2);
	log.info("getting 3rd column from first sheet");
	if (tcexeflg.equalsIgnoreCase("Y")) 
		{
	log.info("ignoring case sensitive");
		
	tcid=xl.getCellData(xlfile, tcsheet, i, 0);
	log.info("getting 1st sheet from sheet1::"+tcid);
	for (int j = 1; j <=tscount ; j++) 
	{
	log.info("iterate second sheet rows");
	tstcid=xl.getCellData(xlfile, tssheet, j, 0);
	if (tcid.equalsIgnoreCase(tstcid)) 
			{
	keyword=xl.getCellData(xlfile, tssheet, j, 4);
	log.info("getting keword sheet from sheet 2");
	switch (keyword.toUpperCase()) 
	{
	case "ADMINLOGIN":
	res=phome.adminlogin("Admin", "Admin");
	log.info("calling admin login method:::"+res);
	break;
	case "NEWBRANCHCREATION":
	ahome.navigateToBranchDetailsPage();			
	res=branchc.createBranch("Kukatpalli", "Hyderabad", "Hydera12", "12345", "INDIA", "Andhra Pradesh", "Hyderabad");
	log.info("calling branchcreation method::"+res);
	break;
	case "ADMINLOGOUT":
	res=ahome.adminLogout();
	log.info("calling admin logout method");
	break;
	}
	String tsres=null;
	if (res) 
	{
	tsres="Pass";
	xl.setCellData(xlfile, tssheet, j, 3, tsres);
	log.info("writing results into second sheet 4 column::"+tsres);
	xl.fillGreenColor(xlfile, tssheet, j, 3);
	} else 
	{
	tsres="Fail";							
	xl.setCellData(xlfile, tssheet, j, 3, tsres);
	log.info("writing results into second sheet 4 column:::"+tsres);
	xl.fillRedColor(xlfile, tssheet, j, 3);
	}
	if (!tcres.equalsIgnoreCase("FAIL")) 
	{
	tcres=tsres;
	}
	}
	}
	xl.setCellData(xlfile, tcsheet, i, 3, tcres);
	if (tcres.equalsIgnoreCase("PASS")) 
	{
	xl.fillGreenColor(xlfile, tcsheet, i, 3);
	}else 
	xl.fillRedColor(xlfile, tcsheet, i, 3);	
	}
	else 
	{
	xl.setCellData(xlfile, tcsheet, i, 3, "Blocked");
	log.info("writing blocked into first sheet 4 column");
	xl.fillRedColor(xlfile, tcsheet, i, 3);
			}
			}
			
		}
		}




