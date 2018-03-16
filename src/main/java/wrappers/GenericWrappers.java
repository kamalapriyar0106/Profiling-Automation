package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers{
	
	RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
			System.out.println("********* Executing invokeApp() Block **********");
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
				driver = new ChromeDriver();	
			} else{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
				driver = new FirefoxDriver();
			}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("The Browser Launched Successfully");
	}

	public void enterById(String idValue, String data) {
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Text field "+idValue+ " is entered with "+data);
	}

	public void enterByName(String nameValue, String data) {
		driver.findElementByName(nameValue).clear();
		driver.findElementByName(nameValue).sendKeys(data);
		System.out.println("The Text field "+nameValue+ " is entered with "+data);
	}

	public void enterByXpath(String xpathValue, String data) {
		driver.findElementByXPath(xpathValue).clear();
		driver.findElementByXPath(xpathValue).sendKeys(data);
		System.out.println("The Text field "+xpathValue+ " is entered with "+data);
	}

	public boolean verifyTitle(String title) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equalsIgnoreCase(title)){
			System.out.println("The actual title "+actualTitle+"matches with the defined title "+title);
		}
		return true;
	}

	public void verifyTextById(String id, String text) {
		System.out.println("********* Executing verifyTextById() Block **********");
		String actualText=driver.findElementById(id).getText();
		if(actualText.equals(text)){
			System.out.println("The Given Text is Present");
		}else{
			System.out.println("The Given Text is not Present and the Actual Text present is: "+actualText);
		}		
	}

	public void verifyTextByXpath(String xpath, String text) {
		System.out.println("********* Executing verifyTextByXpath() Block **********");
		String actualText =  driver.findElementByXPath(xpath).getText();
		if(actualText.equals(text)){
			System.out.println("The Given Text "+actualText+" is Present");
		}else{
			System.out.println("The Given Text is not Present and the Actual Text present is: "+actualText);
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		System.out.println("********* Executing verifyTextContainsByXpath() Block **********");
		String actualText = driver.findElementByXPath(xpath).getText();
		if(actualText.equals(text)){
			System.out.println("The Given Text is Present");
		}else{
			System.out.println("The Given Text is not Present and the Actual Text present is: "+actualText);
		}
	}

	public void clickById(String id) {
		System.out.println("********* Executing clickById() Block **********");
		driver.findElementById(id).click();
		System.out.println("The element with "+id+" is clicked");
	}

	public void clickByClassName(String classVal) {
		System.out.println("********* Executing clickByClassName() Block **********");
		driver.findElementByClassName(classVal).click();
		System.out.println("The element with "+classVal+" is clicked");
	}

	public void clickByName(String name) {
		System.out.println("********* Executing clickByName() Block **********");
		driver.findElementByName(name).click();
		System.out.println("The button "+name+" is clicked");		
	}

	public void clickByLink(String name) {
		System.out.println("********* Executing clickByLink() Block **********");
		driver.findElementByLinkText(name).click();
		System.out.println("The Link "+name+ " is clicked");		
	}

	public void clickByXpath(String xpathVal) {
		System.out.println("********* Executing clickByXpath() Block **********");
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The xpath element is clicked");		
	}
	
	public void clickByMouseHoverUsingId(String hoverid,String elementId) throws InterruptedException{
		WebElement getmenu= driver.findElementById(hoverid); //xpath the parent
	    Actions act = new Actions(driver);
	    act.moveToElement(getmenu).perform();
	    driver.switchTo().frame("_NoviPrintMenu_table_printMenu");
	    Thread.sleep(3000);
	    WebElement clickElement= driver.findElementByXPath(elementId);//xpath the child
	    act.moveToElement(clickElement).click().perform();
	    Thread.sleep(3000);
	    System.out.println("Child element clicked");
	    
	/*	Actions action = new Actions(driver);
		WebElement we = driver.findElementById(hoverid);
		action.moveToElement(we).moveToElement(driver.findElementById(elementId)).click().build().perform();*/
	}
	
/*	public void clickByHoverUsingVisibleText(String hoverid,String childvisibleText) throws InterruptedException{
		WebElement getmenu= driver.findElementById(hoverid); //xpath the parent

	    Actions act = new Actions(driver);
	    act.moveToElement(getmenu).perform();

	    Thread.sleep(3000);
	    WebElement clickElement= driver.findElementById(childvisibleText);//xpath the child
	    act.moveToElement(clickElement).click().perform();
	    
		Actions action = new Actions(driver);
		WebElement we = driver.findElementById(hoverid);
		action.moveToElement(we).moveToElement(driver.findElementById(elementId)).click().build().perform();
	} */
	

    public String getTextById(String idVal) {
    	System.out.println("********* Executing getTextById() Block **********");
		String presentText = driver.findElementById(idVal).getText();
		return presentText;
	}

	public String getTextByXpath(String xpathVal) {
		System.out.println("********* Executing getTextByXpath() Block **********");
		String presentText=driver.findElementByXPath(xpathVal).getText();
		System.out.println("The Text displayed in given XPath is: "+presentText);
		return presentText;
	}

	public void selectVisibileTextById(String id, String value) {
		System.out.println("********* Executing selectVisibileTextById() Block **********");
		WebElement visibleText=driver.findElementById(id);
		Select selectVisibleText = new Select(visibleText);
		selectVisibleText.selectByVisibleText(value);		
	}

	public void selectIndexById(String id, int value) {
		System.out.println("********* Executing selectIndexById() Block **********");
		WebElement indexVal = driver.findElementById(id);
		Select selectIndex = new Select(indexVal);
		selectIndex.selectByIndex(value);
		System.out.println("The Index value "+value+" is clicked");		
	}

	public void switchToParentWindow() {
		try {
			System.out.println("********* Executing switchToParentWindow() Block **********");
			Set<String> secWin = driver.getWindowHandles();
			for (String windowVal : secWin) {
				driver.switchTo().window(windowVal);
				break; //Using break will store the handler of only first handler
			}
		} catch (NoSuchWindowException e) {
			System.err.println("The mentioned window is currently unavailable!");
			driver.close();
			throw new RuntimeException("Stopped Executing");
		}catch (WebDriverException e) {
			System.err.println("Unexpectedly browser closed!");
		//	e.printStackTrace(); It will display bulk details about exceptions in console
		}finally{
			takeSnap();
		}		
	}

	public void switchToLastWindow() {
		try {
			System.out.println("********* Executing switchToLastWindow() Block **********");
			Set<String> secWin = driver.getWindowHandles();
			for (String secondWindow : secWin) {
				driver.switchTo().window(secondWindow);
			}
		} catch (NoSuchWindowException e) {
			System.err.println("The mentioned window is currently unavailable!");
			driver.close();
			throw new RuntimeException("Stopped Executing");
		}catch (WebDriverException e) {
			System.err.println("Unexpectedly browser closed!");
		//	e.printStackTrace(); It will display bulk details about exceptions in console
		}finally{
			takeSnap();
		}		
	}

	public void acceptAlert() {
		System.out.println("********* Executing acceptAlert() Block **********");
		driver.switchTo().alert().accept();		
	}

	public void dismissAlert() {
		System.out.println("********* Executing dismissAlert() Block **********");
		driver.switchTo().alert().dismiss();		
	}

	public String getAlertText() {
		System.out.println("********* Executing dismissAlert() Block **********");
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}

	public void takeSnap() {
		System.out.println("********* Executing takeSnap() Block **********");
		File src = driver.getScreenshotAs(OutputType.FILE);
		int i = 1;
		File dest =  new File("./snap/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.err.println("Cannot perform snapshot in current page!");
		}
		i++;		
	}

	public void closeBrowser() {
		System.out.println("********* Executing closeAllBrowsers() Block **********");
		driver.close();		
	}

	public void closeAllBrowsers() {
		System.out.println("********* Executing closeAllBrowsers() Block **********");
		driver.quit();		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		
	}
	
	public void clickLinkInNewTab(String linkText){
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.linkText(linkText)).sendKeys(selectLinkOpeninNewTab);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	//	System.out.println(newTab);
		driver.switchTo().window(newTab.get(1));
	}

}
