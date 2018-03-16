/* Author: Kamalapriya
 * Date: 04/06/2017
 * Title: Create Test case for Create Lead using Wrapper
 */

package week4HomeWorks;

import org.testng.annotations.Test;

public class CreateLeadUsingWrapper extends ProjectSpecificWrappers{
	@Test(dataProvider="createLead",dataProviderClass=DataProviders.class,groups={"smoke"})
	public void createLead(String company,String firstName,String lastName,String phoneNumber,String email){
		//Using @BeforeMethod concept(From 'ProjectSpecificWrappers')
		//To Click CRM/SFA link
		clickByLink("CRM/SFA");
		//To click Create Lead link
		clickByLink("Create Lead");
		//To Write mandatory fields
		enterById("createLeadForm_companyName", company);
		enterById("createLeadForm_firstName", firstName);
		enterById("createLeadForm_lastName", lastName);
		selectVisibileTextById("createLeadForm_dataSourceId", "Employee");
		selectVisibileTextById("createLeadForm_marketingCampaignId", "Automobile");
		enterById("createLeadForm_primaryPhoneNumber", phoneNumber);
		enterById("createLeadForm_primaryEmail", email);
		//To Click submit button
		clickByClassName("smallSubmit");
	    getTextById("viewLead_companyName_sp");
		//Using @AfterMethod concept(From 'ProjectSpecificWrappers')
	}
	
}
