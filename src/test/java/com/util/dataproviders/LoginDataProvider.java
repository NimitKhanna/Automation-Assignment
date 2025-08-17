package com.util.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtililty;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
    
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\\testData\\loginData.json");
		FileReader fileReader = new FileReader(testDataFile);
		TestData data = gson.fromJson(fileReader, TestData.class);
		
		// Here dataProvider comes into picture which returns Object[] array. Here are are adding data from json to
		// dataPrivider and then pass data to tests
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user : data.getData()) { // getting individual data from data
			dataToReturn.add(new Object[] {user}); // Attaching individual data to ArrayList
		}
		return dataToReturn.iterator(); //It gives data to test case one by one.
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public void loginCSVDataProvider() {
		CSVReaderUtililty.readCSVFile("loginData.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public void loginExcelDataProvider() {
		ExcelReaderUtility.readExcel("LoginData.xlsx");
	}
}
