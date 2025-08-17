package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.config;

public class JSONUtility {

	public static Environment readJson(Env env) {
		Gson gson = new Gson(); // Gson library is used to read json file
		File jsonFile = new File(System.getProperty("user.dir")+ "\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// To read above config.json file
		config config = gson.fromJson(fileReader, config.class);//corresponding java file which represents above config.json is config.java.
		                                                        //entire config.json data will be mapped to config. java class object
		Environment environment = config.getEnvironments().get("QA");//Get me all the environments and out of the give me QA url info
		return environment;// Hence we are able to fetch QA url or reading env info from json file
		
	}

}
