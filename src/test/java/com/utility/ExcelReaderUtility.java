package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcel(String filename) {
		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + filename);
		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;

		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// Skip the column name so that we get only data

			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();
			}
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
