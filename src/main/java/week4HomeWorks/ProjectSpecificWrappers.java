package week4HomeWorks;

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
		invokeApp("chrome", "https://profilingqa.truvenhealth.com/Reports/");
		// To enter Username and password
		enterById("username", "cubeuser1");
		enterById("password", "Cubicle!");
		//To click Login button
		clickById("Login");
	}
	@AfterMethod
	public void quitBrowser(){
		closeBrowser();
	}
}
