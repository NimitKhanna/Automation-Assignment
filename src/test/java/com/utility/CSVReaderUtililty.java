package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtililty {
	public static Iterator<User> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "//testdata//fileName");
		FileReader fileReader = null; // Declaration of a variable should never be done in try block.
		CSVReader csvReader = null;
		String[] line;
		List<User> userList = null;
		User userData;

		try {
			fileReader = new FileReader(csvFile);// Initialization and assignment can be done inside the try block
			csvReader.readNext();// Row 1-> Skip the column names

			userList = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {// Here we are initializing data with readNext and at the
															// same time
				userData = new User(line[0], line[1]);// checking if(above line) it is not equal to null, then we will
														// create a pojo object user
				userList.add(userData);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();// We will pass this in dataProvider having Iterator return type
	}
}