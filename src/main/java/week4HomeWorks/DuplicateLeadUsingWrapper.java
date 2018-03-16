/* Author: Kamalapriya
 * Date: 18/06/2017
 * Title: Create Test case for Duplicating Lead using Wrapper
 */


package week4HomeWorks;


import org.testng.annotations.Test;

public class DuplicateLeadUsingWrapper extends ProjectSpecificWrappers{
	@Test(dataProvider="duplicateLead",dataProviderClass=DataProviders.class,groups={"regression"},dependsOnGroups={"sanity"})
	public void duplicateLead(String name) throws InterruptedException{		
		//Click CRM/SFA Link
		clickByLink("CRM/SFA");
		//Click on Lead Tab
		clickByLink("Leads");
		//Click on Find Lead tab
		clickByLink("Find Leads");
		Thread.sleep(3000);		
		//Enter Lead ID to search
		enterByXpath("(//input[@name='firstName'])[3]", name);
		clickByXpath("//button[text()='Find Leads']");
		//Click on Find Lead button
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		//Capture Text Present in XPath 
		getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
		Thread.sleep(3000);
		//Click The First Link from the result table
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Click Duplicate Lead button from the resultent's page
		clickByLink("Duplicate Lead");
		verifyTitle("Duplicate Lead");
		Thread.sleep(3000);		
		//Cick Create Lead Button
		clickByClassName("smallSubmit");
	//	clickByLink("Find Leads");
	//	verifyTextById("viewLead_firstName_sp", "KpWrapperTest");
		
	}
}
