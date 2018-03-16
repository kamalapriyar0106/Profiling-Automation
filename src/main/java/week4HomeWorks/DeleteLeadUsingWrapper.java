/* Author: Kamalapriya
 * Date: 17/06/2017
 * Title: Create Test case for Delete Lead using TestNG
 */

package week4HomeWorks;

import org.testng.annotations.Test;

public class DeleteLeadUsingWrapper extends ProjectSpecificWrappers{
	@Test(dataProvider="deleteLead",dataProviderClass=DataProviders.class,groups={"sanity"},dependsOnGroups={"smoke"})
	public void duplicateLead(String name) throws InterruptedException{
		//Using @BeforeMethod concept(From 'ProjectSpecificWrappers')
		//To Click CRM/SFA link
				clickByLink("CRM/SFA");
				clickByLink("Leads");
				clickByLink("Find Leads");
				enterByXpath("(//input[@name='firstName'])[3]", name);
				clickByXpath("//button[contains(text(),'Find Leads')]");
				String val= getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
				System.out.println(val);
				clickByXpath("//button[contains(text(),'Find Leads')]");
				Thread.sleep(3000);
				clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
				clickByLink("Delete");
				Thread.sleep(2000);
				clickByLink("Find Leads");
				Thread.sleep(2000);
				enterByXpath("//input[@name='id']", val);
				clickByXpath("//button[contains(text(),'Find Leads')]");
				verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
	}
}
