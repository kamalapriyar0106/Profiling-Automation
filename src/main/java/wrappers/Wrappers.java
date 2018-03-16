package wrappers;


public interface Wrappers {

		
		/**
		 * This method will launch the given browser and maximise the browser and set the
		 * wait for 30 seconds and load the url
		 * @author Kamalapriya
		 * @param browser - The browser of the application to be launched
		 * @param url - The url with http or https
		 * @ 
		 * 
		 */
	    public void invokeApp(String browser, String url) ;

		/**
		 * This method will enter the value to the text field using id attribute to locate
		 * 
		 * @param idValue - id of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Kamalapriya
		 * @return 
		 * @ 
		 */
		public void enterById(String idValue, String data) ;
		
		/**
		 * This method will enter the value to the text field using name attribute to locate
		 * 
		 * @param nameValue - name of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Kamalapriya
		 */
		public void enterByName(String nameValue, String data)  ;	
		
		/**
		 * This method will enter the value to the text field using xpath attribute to locate
		 * 
		 * @param xpathValue - name of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Kamalapriya
		 */
		public void enterByXpath(String xpathValue, String data) ;


		/**
		 * This method will verify the title of the browser 
		 * @param title - The expected title of the browser
		 * @author Kamalapriya
		 */
		public boolean verifyTitle(String title);
		
		/**
		 * This method will verify the given text
		 * @param id - The locator of the object in id
		 * @param text  - The text to be verified
		 * @author Kamalapriya
		 */
		public void verifyTextById(String id, String text);
		
		/**
		 * This method will verify the given text with exact match
		 * @param xpath - The locator of the object in id
		 * @param text  - The text to be verified
		 * @author Kamalapriya
		 */
		public void verifyTextByXpath(String xpath, String text);
		
		/**
		 * This method will verify the given text with partial match
		 * @param xpath - The locator of the object in xpath
		 * @param text  - The text to be verified
		 * @author Kamalapriya
		 */
		public void verifyTextContainsByXpath(String xpath, String text);


		/**
		 * This method will click the element using id as locator
		 * @param id  The id (locator) of the element to be clicked
		 * @author Kamalapriya
		 */
		public void clickById(String id)  ;

		/**
		 * This method will click the element using id as locator
		 * @param id  The id (locator) of the element to be clicked
		 * @author Kamalapriya
		 * @ 
		 */
		public void clickByClassName(String classVal) ;
		
		/**
		 * This method will click the element using name as locator
		 * @param name  The name (locator) of the element to be clicked
		 * @author Kamalapriya
		 */
		public void clickByName(String name)  ;
		

		/**
		 * This method will click the element using link name as locator and do take snap
		 * @param name  The link name (locator) of the element to be clicked
		 * @author Kamalapriya
		 */
		public void clickByLink(String name) ;
		
		/**
		 * This method will click the element using link name as locator and do not take snap
		 * @param name  The link name (locator) of the element to be clicked
		 * @author Kamalapriya
		 */
		public void clickByLinkNoSnap(String name) ;

		/**
		 * This method will click the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element to be clicked
		 * @author Kamalapriya
		 */
		public void clickByXpath(String xpathVal) ;
		
		/**
		 * This method will click the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element to be clicked
		 * @author Kamalapriya
		 */
		public void clickByXpathNoSnap(String xpathVal) ;
		
		/**
		 * This method will get the text of the element using id as locator
		 * @param xpathVal  The id (locator) of the element 
		 * @author Kamalapriya
		 */
		public String getTextById(String idVal);

		/**
		 * This method will get the text of the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element 
		 * @author Kamalapriya
		 */
		public String getTextByXpath(String xpathVal);

		/**
		 * This method will select the drop down visible text using id as locator
		 * @param id The id (locator) of the drop down element
		 * @param value The value to be selected (visibletext) from the dropdown 
		 * @author Kamalapriya
		 */
		public void selectVisibileTextById(String id, String value) ;
		
		/**
		 * This method will select the drop down using index as id locator
		 * @param id The id (locator) of the drop down element
		 * @param value The value to be selected (visibletext) from the dropdown 
		 * @author Kamalapriya
		 */
		public void selectIndexById(String id, int value) ;
		
		/**
		 * This method will switch to the parent Window
		 * @author Kamalapriya
		 */
		public void switchToParentWindow();
		
		/**
		 * This method will move the control to the last window
		 * @author Kamalapriya
		 */
		public void switchToLastWindow();
		
		/**
		 * This method will accept the alert opened
		 * @author Kamalapriya
		 */
		public void acceptAlert();
		
		/**
		 * This method will dismiss the alert opened
		 * @author Kamalapriya
		 */
		public void dismissAlert();
		
		/**
		 * This method will return the text of the alert
		 * @author Kamalapriya
		 */
		public String getAlertText();
		
		/**
		 * This method will take snapshot of the browser
		 * @author Kamalapriya
		 */
		public void takeSnap();
			
		/**
		 * This method will close the active browser
		 * @author Kamalapriya
		 */
		public void closeBrowser();
		
		
		/**
		 * This method will close all the browsers
		 * @author Kamalapriya
		 */
		public void closeAllBrowsers();

}