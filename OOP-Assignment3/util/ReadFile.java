package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * Class to read from a source file
 * @author Prateek Jain
 *
 */
public class ReadFile {
	
/**
 * Function To read a source file line by line and return a list of string 
 * @param fileSource
 * @return
 */

	public List<String> readLineByLine(String fileSource) {
		List<String> linesOfFile = new ArrayList<String>();
		try {
			File file = new File(fileSource);
			if (file.exists()) {
				FileInputStream fileReader = new FileInputStream(file);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					linesOfFile.add(line);
				}
				bufferedReader.close();
				fileReader.close();
			}
		} catch (IOException e) {
			System.out.println("Error Reading Product File\n");
			e.printStackTrace();
		}
		return linesOfFile;
	}
}
