package com.example.util.io.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class CsvWriterTest {
	
	private String defaultPath = CsvWriterTest.class.getName() + ".csv";
	private CsvWriter csvWriter = null;
	
	@After
	public void tearDown() throws IOException {
		if (csvWriter != null) {
			csvWriter.flush();
			csvWriter.close();
			csvWriter = null;
		}
	}
	
	@Test
	public void testWriteLines() throws IOException {
		final String path = defaultPath;
		csvWriter = new CsvWriter(path, CsvWriter.MODE.WRITE, CsvWriter.CHARSET_NAME_UTF_8);
		List<List<String>> allLines = new ArrayList<List<String>>();
		List<String> line1 = new ArrayList<String>();
		line1.add("1");
		allLines.add(line1);
		List<String> line2 = new ArrayList<String>();
		line2.add("2");
		line2.add("3");
		allLines.add(line2);
		List<String> line3 = new ArrayList<String>();
		line3.add("4");
		line3.add("5");
		line3.add("6");
		allLines.add(line3);
		csvWriter.writeLines(allLines);
	}

//	@Test
	public void testWriteLineListOfString() throws IOException {
		final String path = defaultPath;
		csvWriter = new CsvWriter(path, CsvWriter.MODE.APPEND, CsvWriter.CHARSET_NAME_UTF_8);
		List<String> line1 = new ArrayList<String>();
		line1.add("1");
		line1.add("2");
		line1.add("3");
		csvWriter.writeLine(line1);
	}

//	@Test
	public void testWriteLineString() throws IOException {
		final String path = defaultPath;
		csvWriter = new CsvWriter(path, CsvWriter.MODE.APPEND, CsvWriter.CHARSET_NAME_UTF_8);
		String string = "1";
		csvWriter.writeLine(string);
	}

}
