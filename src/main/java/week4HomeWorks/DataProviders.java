package week4HomeWorks;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="createLead")
	public static String[][] createDatas(){
		String[][] data = new String[2][5];
		data[0][0]="VirtusaPolaris";
		data[0][1]="kamalapriya";
		data[0][2]="Ramesh";
		data[0][3]="123456789";
		data[0][4]="kp@gmail.com";
		data[1][0]="CTS";
		data[1][1]="Kiruthika";
		data[1][2]="Selvaraj";
		data[1][3]="987456123";
		data[1][4]="kiruthika@gmail.com";
		return data;

	}
	
	@DataProvider(name="deleteLead")
	public static String[][] deleteDatas(){
		String[][] data = new String[2][1];
		data[0][0]="kamalapriya";
		data[1][0]="kamalapriya";
		return data;		
	}
	
	@DataProvider(name="duplicateLead")
		public static String[][] duplicatingData(){
			String[][] data = new String[1][1];
			data[0][0]="kamalapriya";
			return data;
		}
	
	@DataProvider(name="editLead")
	public static String[][] editDatas(){
		String[][] data = new String[1][2];
		data[0][0]="Kamalapriya";
		data[0][1]="VP";
		return data;
	}
	
	@DataProvider(name="mergeLead")
	public static String[][] mergeDatas(){
		String[][] data = new String[2][2];
		data[0][0]="10603";
		data[0][1]="10596";
		data[1][0]="10588";
		data[1][1]="10583";
		return data;
	}

}
