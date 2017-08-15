package com.metacube.shoppingCart.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility Class used to read and write data from file and to file
 * @author Prateek Jain
 *
 */
public class FileHandling {
	private static FileHandling fileHandling;
	
	/**
	 * Function to make class a singleton
	 * @return
	 */
	public static FileHandling getInstance() {
		//if fileHandling is null then initialize it
		if (fileHandling == null) {
			//synchronized the function and double check it
			synchronized (FileHandling.class) {
				if (fileHandling == null) {
					fileHandling = new FileHandling();
				}
			}
		}
		return fileHandling;
	}
	/**
	 * Function is used to Read file
	 * 
	 * @param filePath
	 *           
	 * @return 
	 * @throws IOException 
	 * 
	 */
	public List<String> read(String filePath) throws IOException {
		List<String> list = new ArrayList<String>();
		list = Files.readAllLines(Paths.get(filePath));
		return list;
	}

	/**
	 * Function is used to  Write in File
	 * 
	 * @param billDetails
	 * @param filePath
	 * @throws IOException 
	 * 
	 */
	public void write(String billDetails) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Constants.CART_BILL_PATH)));
		writer.write(billDetails);
		writer.close();
	}
}
