package com.metacube.restwebservice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Method to handle the file read and write 
 * 
 * @author Prateek Jain
 *
 */
public class JsonFilehandling {
	private static FileWriter file;
	private static BufferedReader bufferedReader;
	public static List<JSONObject> read() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		String string;
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
			File readfromFile = new File("/WorkSpace/RestWebService/src/employees.json");
			FileInputStream fileReader = new FileInputStream(readfromFile);
			bufferedReader = new BufferedReader(new InputStreamReader(fileReader)); 
			while ((string = bufferedReader.readLine()) != null) {
				jsonObj = (JSONObject) parser.parse(string);
				list.add((JSONObject) jsonObj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Method to write to file
	 * @param details
	 */
	public static void write(Object details) {
		JSONObject jsonObj = (JSONObject) details;
		//check if object value is empty
		if(!jsonObj.isEmpty()){
			try {
				file = new FileWriter(
						"/WorkSpace/RestWebService/src/employees.json", true);
				file.write(jsonObj.toJSONString());
				file.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.print(jsonObj);
	}
	/**
	 * Method to clear the file
	 */
	public static void clearFile(){
		try{
			file = new FileWriter(
					"/WorkSpace/RestWebService/src/employees.json");
			file.write("");
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}