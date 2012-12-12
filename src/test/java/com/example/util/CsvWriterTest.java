package test.java.com.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.example.util.CsvWriter;

import org.junit.After;
import org.junit.Test;

public class CsvWriterTest {
	
	private CsvWriter csvWriter = null;
	
	@After
	public void tearDown() throws IOException {
		if (csvWriter != null) {
			csvWriter.flush();
			csvWriter.close();
			csvWriter = null;
		}
	}
	
//	@Test
	public void testWriteLines() throws IOException {
		final String path = "CsvWriterTest.csv";
		csvWriter = new CsvWriter(path);
		List<List<String>> allLines = new ArrayList<List<String>>();
		List<String> line1 = new ArrayList<String>();
		line1.add("1");
		allLines.add(line1);
		List<String> line2 = new ArrayList<String>();
		line2.add("2");
		allLines.add(line2);
		csvWriter.writeLines(allLines);
	}

//	@Test
	public void testWriteLineListOfString() throws IOException {
		final String path = "CsvWriterTest.csv";
		csvWriter = new CsvWriter(path);
		List<String> line1 = new ArrayList<String>();
		line1.add("1");
		line1.add("2");
		line1.add("3");
		csvWriter.writeLine(line1);
	}

//	@Test
	public void testWriteLineString() throws IOException {
		final String path = "CsvWriterTest.csv";
		csvWriter = new CsvWriter(path);
		String string = "1";
		csvWriter.writeLine(string);
	}

}
