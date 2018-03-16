package profilingTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import wrappers.GenericWrappers;

public class ProjectSpecificWrappers extends GenericWrappers{
//	@Parameters({"browser","url","username","password"})
	@BeforeMethod
//	public void Login(String driver,String url,String uname,String pswd)
	public void Login(){
		// function present in GenericWrappers class to cover all basic browser start functions.
		invokeApp("chrome", "http://leaftaps.com/control/main");
		// To enter Username and password
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		//To click Login button
		clickByClassName("decorativeSubmit");
	}
	@AfterMethod
	public void quitBrowser(){
		closeBrowser();
	}
}
