package socialNetwork.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read and Write data
 * 
 * @author Prateek Jain
 *
 */
public class FileUtility {
	/**
	 * Read data from file
	 * 
	 * @param filePath
	 * @return
	 */
	public List<String> read(String filePath) throws IOException {
		List<String> fileData = new ArrayList<String>();
		File file = new File(filePath);
		/*
		 * if file exists then read from file 
		 * else throw fileNot Found exception
		 */
		if (file.exists()) {
			FileInputStream fileReader = new FileInputStream(file);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
			String line = "";
			//loop iterate till file end
			while ((line = bufferedReader.readLine()) != null) {
				fileData.add(line);
			}
			bufferedReader.close();
			fileReader.close();
		}
		else{
			throw new FileNotFoundException();
		}
		return fileData;
	}
	/**
	 * Method to write details to a file
	 * 
	 * @param details
	 * @param filePath
	 * @throws IOException
	 */
	public void write(String details, String filePath) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
		writer.write(details);
		writer.close();
	}
}
