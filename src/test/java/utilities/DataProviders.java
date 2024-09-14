package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\opencart_LoginData.xlsx";    // taking Excel file from testData
		
		ExcelUtility xlutil= new ExcelUtility(path);   // creating object of ExcekUtility class
		int totalrows=xlutil.getRowCount("Sheet1");    // calling the methods ExcelUtility class
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];  //Created2d array which can store the excel file data
		
		for(int i=0; i<=totalrows; i++)  //value start from 0. but we are not taking the heading part, so start from 1
		{
			for(int j=0; i<totalcols; j++)  //value start from 0
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i, j);
			}
		}
		
		return logindata;  // returning 2d array
		
		
	}

}
