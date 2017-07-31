package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * This is a utility class to read from and write to File
 * @author Prateek Jain
 *
 */
public class FileHandling {

	/**
	 * Method read file is used to access file contents
	 * 
	 * @param filePath path of file
	 * @return array of string containing file contents split by ','
	 */
	public String[][] read(String filePath) {
		String text[][] = new String[5][];
		int index = 0;
		try {
			// Read the file from filePath
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String str = "";
			// Read File Line By Line
			while ((str = br.readLine()) != null) {
				text[index++] = str.split(",");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error: file not found");
		}
		return text;
	}

	/**
	 * Function is used to write the text into file at filePath
	 * 
	 * @param text
	 * @param filePath
	 */
	public void writeToFile(String text, String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true));
			if (text.equals("-1")) {
				bw.newLine();
			} else {
				bw.write(text);
			}
			bw.close();
		} catch (IOException ie) {
			System.out.println("Error: File not found");
		}
	}
}
