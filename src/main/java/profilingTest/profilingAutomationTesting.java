package profilingTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class profilingAutomationTesting extends ProfilingSpecificWrappers{	
	
	
		@Test
		public void loginToPHR() throws InterruptedException{
			verifyTitle("Profiling - Global");
			Thread.sleep(3000);
			selectVisibileTextById("ApplicationList", "Patient Profiling");
		//	VerifyPPTitle();
			verifyTitle("Patient Profiling");
			// Selecting Database
			selectVisibileTextById("ConditionsList", "Cardiology Cost Report");
			clickById("SearchButton");
			clickByXpath("//div[@class='lockedItemInner']/span/input");
		}
		
		@Test
		public void PPPageTesting() throws InterruptedException{
			//Click on "Export to CSV"
			clickById("Results_exportToCsv_ShowHide");
			Thread.sleep(3000);
			//Closing current window
			switchToLastWindow();
			closeBrowser();
			clickById("Results_advancedSort_ShowHide");
		}
		
		@Test(enabled=false)
		public void phrPatientSummaryTest() throws InterruptedException{
			// Verify Page title
			verifyTextByXpath("//h1[@id='subproductName']", "Patient Health Record");
			// Verify Tag
			verifyTextByXpath("//a[@id='MemberSummary']", "Patient Summary");
			// Click 'Export to PDF' cannot perform
		//	clickByMouseHoverUsingId("printMenu_link_Id","//td[@id='viewPDFJobs_td']/a[@id='viewPDFJobs']");
			//Click Help
			clickById("helpLink");
			switchToLastWindow();
			clickByLink("Navigating to a Patient Health Record");
			//Click "Patient List" in new tab and changing focus to corresponding tab
			clickLinkInNewTab("Using Patient Lists");
			//Click "Patient Health Record - Patient Summary" in new tab
			clickLinkInNewTab("Patient Health Record - Patient Summary");
		//	switchToLastWindow();
		//	scrollWindowVisibleText();
		}
		
		@Test(enabled=false)
		public void phrValidationPage(){
			clickById("MemberRecommendedServices"); //Selecting "Recommended Care"
			clickById("MemberRecommendedCare_PreventiveServicesGrid_advancedSort_ShowHide"); //Selecting "Advanced Sort"
			selectVisibileTextById("MemberRecommendedCare_PreventiveServicesGrid_advancedSort_ColumnList1", "Frequency"); //Select "Sort by"
			selectVisibileTextById("MemberRecommendedCare_PreventiveServicesGrid_advancedSort_ColumnList2", "Service");
			clickById("MemberRecommendedCare_PreventiveServicesGrid_advancedSort_ColumnOrder2");
			selectVisibileTextById("MemberRecommendedCare_PreventiveServicesGrid_advancedSort_ColumnList3", "Status");
			clickById("MemberRecommendedCare_PreventiveServicesGrid_advancedSort_ApplyButton");
		}
}