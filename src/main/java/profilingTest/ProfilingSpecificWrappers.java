package profilingTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import wrappers.GenericWrappers;


public class ProfilingSpecificWrappers extends GenericWrappers {


    @BeforeSuite
	public void login() {
		
		invokeApp("chrome","http://profilingqa.truvenhealth.com/reports");
		//Entering username and password
		enterById("UserName", "cubeuser1");
		enterById("Password", "Cubicle!");
		//Click Login button
		clickById("Login");

/*		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("************ Executing Login() block ************");
		driver.get("http://profilingqa.truvenhealth.com/reports");
		driver.findElementById("UserName").sendKeys("cubeuser1");
		driver.findElementById("Password").sendKeys("Cubicle!");
		driver.findElementById("Login").click();  */
	}
	
}
