/* Author: Kamalapriya
 * Date: 04/06/2017
 * Title: Create Test case for Merge Lead using Wrapper
 */

package week4HomeWorks;

import org.testng.annotations.Test;

public class MergeLeadUsingWrapper extends ProjectSpecificWrappers{
	@Test(dataProvider="mergeLead",dataProviderClass=DataProviders.class,groups={"smoke"})
	public void mergeLead(String fromLeadId,String toLeadId) throws InterruptedException{
		//To Click CRM/SFA link
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Merge Leads");
		//Click Icon Next to 'From Lead'
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		Thread.sleep(3000);
		//Enter Lead id to search
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", fromLeadId);
		//Click 'Find Leads' Button
		clickByClassName("x-btn-text");
		Thread.sleep(3000);
		//Click First Search Result
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		//Switch Back focus to Parent Window
		switchToParentWindow();
		//Click Button next to 'To Lead'
		Thread.sleep(3000);
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		Thread.sleep(3000);
		//Enter Lead id to search
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", toLeadId);
		//Click Find Lead Button
		clickByXpathNoSnap("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		//Click First Search Result
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		Thread.sleep(3000);
		//Switch to parent Window
		switchToParentWindow();
		//Click on Merge button
		clickByLinkNoSnap("Merge");
		// Click on "OK" from alert window
		acceptAlert();
		//Click "Find Leads" Link from the left panel
		clickByLink("Find Leads");
		enterByXpath("//input[@name='id']", fromLeadId);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
	}
}
