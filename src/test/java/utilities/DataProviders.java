package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	// DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException { 
	    String path = ".\\testData\\Opencart_LoginData.xlsx"; // taking Excel file from testData
	    ExcelUtility xlutil = new ExcelUtility(path); // creating an object for ExcelUtility

	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);

	    String logindata[][] = new String[totalrows][totalcols]; // created a two-dimensional array to store data

	    for (int i = 1; i <= totalrows; i++) { // Reading the data from Excel and storing it in a two-dimensional array
	        for (int j = 0; j < totalcols; j++) { // i represents rows, j represents columns
	            logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Storing data from Excel (row, col)
	        }
	    }
	    return logindata; // Returning the two-dimensional array
	}


}
