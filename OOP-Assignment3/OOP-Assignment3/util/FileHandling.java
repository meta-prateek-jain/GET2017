package util;

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

public class FileHandling {
	/**
	 * Function To read a source file line by line and return a list of string 
	 * @param fileSource
	 * @return
	 * @throws IOException 
	 */

		public List<String> readLineByLine(String fileSource) throws IOException {
			List<String> linesOfFile = new ArrayList<String>();
			File file = new File(fileSource);
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
						linesOfFile.add(line);
					}
					bufferedReader.close();
					fileReader.close();
				}
				else{
					throw new FileNotFoundException();
				}
			return linesOfFile;
		}
		
		/**
		 * Method to write a string to a file
		 * @param stringToWrite
		 * @param destinationFile
		 */
		
		public static void write(String stringToWrite,String destinationFile) {
			int fileCounter=0;
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File(destinationFile)));
				//loop iterate till string end
				for(int index =0; index < stringToWrite.length(); index++){
					char character = stringToWrite.charAt(index);
					/*
					 * if character is \n then move writer to new line
					 * else write the character to file
					 */
					if(character =='\n'){
						writer.newLine();
					}else{
						writer.write(character);
					}
				}
				writer.close();
			} catch(IOException e) {
				System.out.println("Billing File Not Found or UnAccesible:Printing to a different File: New"+(fileCounter++)+destinationFile);
				FileHandling.write(stringToWrite,"New"+(fileCounter++)+destinationFile);
			}
		}
}
