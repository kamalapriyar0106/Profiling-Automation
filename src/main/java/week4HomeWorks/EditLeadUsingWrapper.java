/* Author: Kamalapriya
 * Date: 04/06/2017
 * Title: Create Test case for Create Lead using Wrapper
 */

package week4HomeWorks;


import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class EditLeadUsingWrapper extends ProjectSpecificWrappers{
	@Test(dataProvider="editLead",dataProviderClass=DataProviders.class,groups={"sanity"},dependsOnGroups={"smoke"})
	public void editLead(String name,String company) throws InterruptedException{
		//To Click CRM/SFA link
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Find Leads");
		enterByXpath("(//input[@name='firstName'])[3]",name);
		clickByXpath("//button[text()='Find Leads']");
		Thread.sleep(3000);
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		verifyTitle("View Lead | opentaps CRM");
		clickByLink("Edit");
		enterById("updateLeadForm_companyName",company);
		clickByName("submitButton");
		verifyTextById("viewLead_companyName_sp",company);
	
	}
}
