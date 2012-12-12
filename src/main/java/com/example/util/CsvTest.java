package main.java.com.example.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvTest {

	public static void main(String[] args) {
		CsvWriter csvWriter = null;
		try {
			csvWriter = new CsvWriter("example.csv");
			String string = "1";
			csvWriter.writeLine(string);
			List<String> line = new ArrayList<String>();
			line.add("2");
			line.add("3");
			csvWriter.writeLine(line);
//			List<List<String>> lines = new ArrayList<List<String>>();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (csvWriter != null) {
				try {
					csvWriter.flush();
					csvWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}
}
